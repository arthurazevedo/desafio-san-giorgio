package com.arthurazevedo.pagamento.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Cobranca {
    private Long codigo;
    private BigDecimal valor;
}
