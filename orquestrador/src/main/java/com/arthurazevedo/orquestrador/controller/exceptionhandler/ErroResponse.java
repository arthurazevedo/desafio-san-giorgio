package com.arthurazevedo.orquestrador.controller.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErroResponse {
    private int codigo;
    private  String message;
}
