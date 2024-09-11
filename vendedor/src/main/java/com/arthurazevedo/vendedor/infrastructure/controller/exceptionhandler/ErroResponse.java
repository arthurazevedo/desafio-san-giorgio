package com.arthurazevedo.vendedor.infrastructure.controller.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroResponse {
    private int codigo;
    private  String message;
}
