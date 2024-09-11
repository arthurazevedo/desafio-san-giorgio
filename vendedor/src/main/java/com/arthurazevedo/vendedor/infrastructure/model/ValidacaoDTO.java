package com.arthurazevedo.vendedor.infrastructure.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidacaoDTO {
    private int status;
    private String mensagem;
}
