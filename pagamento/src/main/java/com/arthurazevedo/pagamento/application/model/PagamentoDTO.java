package com.arthurazevedo.pagamento.application.model;

import com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class PagamentoDTO {
    private Long codigoCobranca;
    private StatusPagamento statusPagamento;
    private BigDecimal valorPagamento;
}
