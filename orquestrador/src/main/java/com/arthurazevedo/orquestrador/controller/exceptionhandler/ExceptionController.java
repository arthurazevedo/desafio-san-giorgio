package com.arthurazevedo.orquestrador.controller.exceptionhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErroResponse> handleFeignStatusException(FeignException e) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        int status = e.status();
        return ResponseEntity.status(status).body(mapper.readValue(e.contentUTF8(), ErroResponse.class));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> requestException(MethodArgumentNotValidException ex) {

        String mensagemErro = String.join(", ", ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList());
        ErroResponse erro = new ErroResponse(BAD_REQUEST.value(), mensagemErro);
        return ResponseEntity.badRequest().body(erro);
    }
}
