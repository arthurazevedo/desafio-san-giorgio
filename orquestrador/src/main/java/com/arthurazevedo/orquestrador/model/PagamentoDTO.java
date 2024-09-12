package com.arthurazevedo.orquestrador.model;

import com.arthurazevedo.orquestrador.model.enums.StatusPagamento;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PagamentoDTO {
    @NotNull(message = "codigoCobranca nao pode ser nulo")
    private Long codigoCobranca;

    private StatusPagamento statusPagamento;

    @NotNull(message = "valorPagamento nao pode ser nulo")
    private BigDecimal valorPagamento;
}
