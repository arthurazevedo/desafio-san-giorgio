package com.arthurazevedo.pagamento.application.usecase;

import com.arthurazevedo.pagamento.application.exception.CobrancaNaoEncontradaException;
import com.arthurazevedo.pagamento.domain.model.Cobranca;
import com.arthurazevedo.pagamento.domain.model.EntradaPagamento;
import com.arthurazevedo.pagamento.domain.model.Pagamento;
import com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento;
import com.arthurazevedo.pagamento.domain.repository.CobrancaRepository;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;

import static com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento.EXCEDENTE;
import static com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento.PARCIAL;
import static com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento.TOTAL;

@Slf4j
public class ProcessaPagamento {

    private static final int ZERO = 0;
    private CobrancaRepository cobrancaRepository;
    private ValidaCobranca validaCobranca;
    private PagamentoSQSProcessor processador;

    public ProcessaPagamento(CobrancaRepository cobrancaRepository, ValidaCobranca validaCobranca, PagamentoSQSProcessor processador) {
        this.cobrancaRepository = cobrancaRepository;
        this.validaCobranca = validaCobranca;
        this.processador = processador;
    }

    public EntradaPagamento execute(EntradaPagamento entradaPagamentos) {

        log.info("Iniciado processamento de pagamento");

        validaCobrancas(entradaPagamentos);

        List<Pagamento> pagemtnosEnviados = entradaPagamentos.getPagamentos().stream()
                .map(pagamento -> processa(entradaPagamentos.getCodigoVendedor(), pagamento))
                .toList();

        entradaPagamentos.setPagamentos(pagemtnosEnviados);
        return entradaPagamentos;
    }

    private Pagamento processa(Long codigoVendedor, Pagamento pagamento) {
        Long codigoCobranca = pagamento.getCodigoCobranca();

        Cobranca cobranca = cobrancaRepository.getByCodigoAndVendedor(codigoCobranca, codigoVendedor)
                .orElseThrow(() -> new CobrancaNaoEncontradaException(codigoCobranca, codigoVendedor));

        pagamento.setStatusPagamento(validaStatus(cobranca, pagamento));

        processador.processa(pagamento);
        return pagamento;
    }

    private StatusPagamento validaStatus(Cobranca cobranca, Pagamento pagamento) {
        log.info("Subtraindo valores: {} - {}", cobranca, pagamento.getValorPagamento());
        BigDecimal valorRestante = cobranca.getValor().subtract(pagamento.getValorPagamento());

        if (valorRestante.compareTo(BigDecimal.ZERO) > ZERO) {
            return PARCIAL;
        } else if (valorRestante.compareTo(BigDecimal.ZERO) < ZERO) {
            return EXCEDENTE;
        }

        return TOTAL;
    }

    private void validaCobrancas(EntradaPagamento entradaPagamentos) {
        log.info("Validando cobrancas");

        Long codigoVendedor = entradaPagamentos.getCodigoVendedor();

        for (Pagamento pagamento : entradaPagamentos.getPagamentos()) {
            validaCobranca.execute(codigoVendedor, pagamento);
        }
    }
}
