package com.arthurazevedo.pagamento.application.usecase;

import com.arthurazevedo.pagamento.domain.model.Pagamento;
import com.arthurazevedo.pagamento.infrastructure.messaging.PagamentoExcedenteProducer;
import com.arthurazevedo.pagamento.infrastructure.messaging.PagamentoParcialProducer;
import com.arthurazevedo.pagamento.infrastructure.messaging.PagamentoTotalProducer;

import static com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento.EXCEDENTE;
import static com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento.PARCIAL;
import static com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento.TOTAL;

public class PagamentoSQSProcessor {

    private PagamentoParcialProducer pagamentoParcialProducer;
    private PagamentoTotalProducer pagamentoTotalProducer;
    private PagamentoExcedenteProducer pagamentoExcedenteProducer;

    public PagamentoSQSProcessor(PagamentoParcialProducer pagamentoParcialProducer, PagamentoTotalProducer pagamentoTotalProducer,
                                 PagamentoExcedenteProducer pagamentoExcedenteProducer) {
        this.pagamentoParcialProducer = pagamentoParcialProducer;
        this.pagamentoTotalProducer = pagamentoTotalProducer;
        this.pagamentoExcedenteProducer = pagamentoExcedenteProducer;
    }

    public void processa(Pagamento pagamento) {

        if (TOTAL.equals(pagamento.getStatusPagamento())) {
            pagamentoTotalProducer.enviarMensagem(pagamento.toString());
        } else if (PARCIAL.equals(pagamento.getStatusPagamento())) {
            pagamentoParcialProducer.enviarMensagem(pagamento.toString());
        } else if (EXCEDENTE.equals(pagamento.getStatusPagamento())) {
            pagamentoExcedenteProducer.enviarMensagem(pagamento.toString());
        }
    }
}
