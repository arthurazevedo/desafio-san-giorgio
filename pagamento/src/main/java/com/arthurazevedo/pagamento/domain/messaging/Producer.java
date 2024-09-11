package com.arthurazevedo.pagamento.domain.messaging;

public interface Producer {

    void enviarMensagem(String message);
}
