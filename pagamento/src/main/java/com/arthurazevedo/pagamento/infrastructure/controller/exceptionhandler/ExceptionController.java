package com.arthurazevedo.pagamento.infrastructure.controller.exceptionhandler;

import com.arthurazevedo.pagamento.application.exception.CobrancaNaoEncontradaException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CobrancaNaoEncontradaException.class)
    public ResponseEntity<ErroResponse> cobrancaNaoEncontrada(CobrancaNaoEncontradaException ex) {
        ErroResponse erro = new ErroResponse(UNPROCESSABLE_ENTITY.value(), ex.getMessage());
        return ResponseEntity.unprocessableEntity().body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> requestException(MethodArgumentNotValidException ex) {

        String mensagemErro = String.join(", ", ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList());
        ErroResponse erro = new ErroResponse(BAD_REQUEST.value(), mensagemErro);
        return ResponseEntity.badRequest().body(erro);
    }
}
