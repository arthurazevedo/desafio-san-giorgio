package com.arthurazevedo.vendedor.application.exception;

public class VendedorNaoEncontradoException extends RuntimeException {

    private static final String MENSAGEM = "Nao foi encontrado registro para o vendedor de id: %d";

    public VendedorNaoEncontradoException(Long codigoVendedor) {
        super(String.format(MENSAGEM, codigoVendedor));
    }
}
