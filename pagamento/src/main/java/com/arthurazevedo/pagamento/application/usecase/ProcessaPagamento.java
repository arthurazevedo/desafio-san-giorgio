package com.arthurazevedo.pagamento.application.usecase;

import com.arthurazevedo.pagamento.domain.messaging.Producer;
import com.arthurazevedo.pagamento.domain.repository.CobrancaRepository;

public class ProcessaPagamento {

    private CobrancaRepository cobrancaRepository;

    private Producer producer;

    public ProcessaPagamento(CobrancaRepository cobrancaRepository) {
        this.cobrancaRepository = cobrancaRepository;
    }
}
