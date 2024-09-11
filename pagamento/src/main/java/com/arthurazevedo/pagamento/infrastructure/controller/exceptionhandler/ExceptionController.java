package com.arthurazevedo.pagamento.infrastructure.controller.exceptionhandler;

import com.arthurazevedo.pagamento.application.exception.CobrancaNaoEncontradaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CobrancaNaoEncontradaException.class)
    public ResponseEntity<ErroResponse> cobrancaNaoEncontrada(CobrancaNaoEncontradaException ex) {
        ErroResponse erro = new ErroResponse(BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.badRequest().body(erro);
    }
}
