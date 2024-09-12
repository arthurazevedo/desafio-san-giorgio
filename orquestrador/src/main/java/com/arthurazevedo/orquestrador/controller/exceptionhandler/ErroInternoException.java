package com.arthurazevedo.orquestrador.controller.exceptionhandler;

public class ErroInternoException extends RuntimeException {

    public ErroInternoException() {
        super("Erro interno");
    }
}
