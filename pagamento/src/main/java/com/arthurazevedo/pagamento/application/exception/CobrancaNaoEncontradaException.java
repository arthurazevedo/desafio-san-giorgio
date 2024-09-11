package com.arthurazevedo.pagamento.application.exception;

public class CobrancaNaoEncontradaException extends RuntimeException{

    private static final String MENSAGEM = "Não foi encontrado registro para cobranca de id: ";

    public CobrancaNaoEncontradaException(Long clientId) {
        super(MENSAGEM + clientId);
    }
}
