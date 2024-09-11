package com.arthurazevedo.pagamento.domain.messaging;

public interface FilaExcedenteProducer {
    void enviarMensagem(String message);
}
