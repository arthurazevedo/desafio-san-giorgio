package com.arthurazevedo.vendedor.infrastructure.controller.exceptionhandler;

import com.arthurazevedo.vendedor.application.exception.VendedorNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(VendedorNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> vendedorNaoEncontrado(VendedorNaoEncontradoException ex) {
        ErroResponse erro = new ErroResponse(UNPROCESSABLE_ENTITY.value(), ex.getMessage());
        return ResponseEntity.unprocessableEntity().body(erro);
    }
}
