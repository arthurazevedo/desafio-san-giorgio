package com.arthurazevedo.pagamento.domain.messaging;

public interface FilaParcialProducer {
    void enviarMensagem(String message);
}
