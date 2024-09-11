package com.arthurazevedo.pagamento.application.usecase;

import com.arthurazevedo.pagamento.application.exception.CobrancaNaoEncontradaException;
import com.arthurazevedo.pagamento.domain.model.Pagamento;
import com.arthurazevedo.pagamento.domain.repository.CobrancaRepository;

public class ValidaCobranca {

    private CobrancaRepository cobrancaRepository;

    public ValidaCobranca(CobrancaRepository cobrancaRepository) {
        this.cobrancaRepository = cobrancaRepository;
    }

    public void execute(Long codigoVendedor, Pagamento pagamento) {
        cobrancaRepository
                .getByCodigoAndVendedor(pagamento.getCodigoCobranca(), codigoVendedor)
                .orElseThrow(() -> new CobrancaNaoEncontradaException(pagamento.getCodigoCobranca(), codigoVendedor));
    }
}
