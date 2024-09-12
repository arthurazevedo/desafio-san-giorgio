package com.arthurazevedo.pagamento.application.usecase;

import com.arthurazevedo.pagamento.domain.model.Pagamento;
import com.arthurazevedo.pagamento.infrastructure.messaging.PagamentoExcedenteProducer;
import com.arthurazevedo.pagamento.infrastructure.messaging.PagamentoParcialProducer;
import com.arthurazevedo.pagamento.infrastructure.messaging.PagamentoTotalProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento.EXCEDENTE;
import static com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento.PARCIAL;
import static com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento.TOTAL;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
 class PagamentoSQSProcessorTest {

    @InjectMocks
    private PagamentoSQSProcessor pagamentoSQSProcessor;
    @Mock
    private PagamentoParcialProducer pagamentoParcialProducer;
    @Mock
    private PagamentoTotalProducer pagamentoTotalProducer;
    @Mock
    private PagamentoExcedenteProducer pagamentoExcedenteProducer;
    private Pagamento pagamento;

    @BeforeEach
    void setUp() {
        pagamento = new Pagamento(1L, TOTAL, BigDecimal.ONE);
    }

    @Test
    void processaTotal() {
        doNothing().when(pagamentoTotalProducer).enviarMensagem(pagamento.toString());
        assertDoesNotThrow(() -> pagamentoSQSProcessor.processa(pagamento));
    }

    @Test
    void processaParcial() {
        pagamento.setStatusPagamento(PARCIAL);
        doNothing().when(pagamentoParcialProducer).enviarMensagem(pagamento.toString());
        assertDoesNotThrow(() -> pagamentoSQSProcessor.processa(pagamento));
    }

    @Test
    void processaExcedente() {
        pagamento.setStatusPagamento(EXCEDENTE);
        doNothing().when(pagamentoExcedenteProducer).enviarMensagem(pagamento.toString());
        assertDoesNotThrow(() -> pagamentoSQSProcessor.processa(pagamento));
    }
}
