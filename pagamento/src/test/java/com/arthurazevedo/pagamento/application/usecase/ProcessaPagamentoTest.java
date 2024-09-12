package com.arthurazevedo.pagamento.application.usecase;

import com.arthurazevedo.pagamento.application.exception.CobrancaNaoEncontradaException;
import com.arthurazevedo.pagamento.domain.model.Cobranca;
import com.arthurazevedo.pagamento.domain.model.EntradaPagamento;
import com.arthurazevedo.pagamento.domain.model.Pagamento;
import com.arthurazevedo.pagamento.domain.repository.CobrancaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento.EXCEDENTE;
import static com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento.PARCIAL;
import static com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento.TOTAL;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class ProcessaPagamentoTest {

    @InjectMocks
    private ProcessaPagamento processaPagamento;
    @Mock
    private CobrancaRepository cobrancaRepository;
    @Mock
    private ValidaCobranca validaCobranca;
    @Mock
    private PagamentoSQSProcessor processador;

    private Long codigoVendedor = 1L;
    private Pagamento pagamento;

    private List<Pagamento> listaPagamentos;
    private EntradaPagamento entradaPagamento;

    @BeforeEach
    void setUp() {

        pagamento = new Pagamento(1L, null, BigDecimal.valueOf(2.5));
        listaPagamentos =  List.of(pagamento);
        entradaPagamento = new EntradaPagamento(codigoVendedor, listaPagamentos);

        doNothing().when(validaCobranca).execute(codigoVendedor, pagamento);
        when(cobrancaRepository.getByCodigoAndVendedor(pagamento.getCodigoCobranca(), codigoVendedor))
                .thenReturn(Optional.of(criaCobranca()));
    }

    @Test
    void processaComSucessoTotal() {

        doNothing().when(processador).processa(pagamento);

        List<Pagamento> listaPagamentos = List.of(pagamento);
        EntradaPagamento entradaPagamento = new EntradaPagamento(codigoVendedor, listaPagamentos);

        assertDoesNotThrow(() -> {
            EntradaPagamento retorno = processaPagamento.execute(entradaPagamento);
            assertEquals(TOTAL, retorno.getPagamentos().get(0).getStatusPagamento());
        });
    }

    @Test
    void processaComSucessoParcial() {

        doNothing().when(processador).processa(pagamento);

        pagamento.setValorPagamento(BigDecimal.valueOf(1));

        assertDoesNotThrow(() -> {
            EntradaPagamento retorno = processaPagamento.execute(entradaPagamento);
            assertEquals(PARCIAL, retorno.getPagamentos().get(0).getStatusPagamento());
        });
    }

    @Test
    void processaComSucessoExcedente() {

        doNothing().when(processador).processa(pagamento);

        pagamento.setValorPagamento(BigDecimal.valueOf(10));

        assertDoesNotThrow(() -> {
            EntradaPagamento retorno = processaPagamento.execute(entradaPagamento);
            assertEquals(EXCEDENTE, retorno.getPagamentos().get(0).getStatusPagamento());
        });
    }

    @Test
    void processaComFalha() {
        when(cobrancaRepository.getByCodigoAndVendedor(pagamento.getCodigoCobranca(), codigoVendedor))
                .thenReturn(Optional.empty());

        assertThrows(CobrancaNaoEncontradaException.class, () -> processaPagamento.execute(entradaPagamento));
    }

    private Cobranca criaCobranca() {
        Cobranca cobranca = new Cobranca();
        cobranca.setCodigo(1L);
        cobranca.setValor(BigDecimal.valueOf(2.5));
        return cobranca;
    }
}
