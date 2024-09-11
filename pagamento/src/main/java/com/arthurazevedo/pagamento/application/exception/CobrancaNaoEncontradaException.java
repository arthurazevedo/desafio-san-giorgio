package com.arthurazevedo.pagamento.application.exception;

public class CobrancaNaoEncontradaException extends RuntimeException{

    private static final String MENSAGEM = "Não foi encontrado registro para cobranca de id %d para o vendedor %d";

    public CobrancaNaoEncontradaException(Long codigoCobranca, Long codigoVendedor) {
        super(String.format(MENSAGEM, codigoCobranca, codigoVendedor));
    }
}
