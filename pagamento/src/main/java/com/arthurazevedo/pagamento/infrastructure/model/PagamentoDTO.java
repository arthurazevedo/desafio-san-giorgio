package com.arthurazevedo.pagamento.infrastructure.model;

import com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@AllArgsConstructor
public class PagamentoDTO {

    @NotNull(message = "codigoCobranca nao pode ser nulo")
    private Long codigoCobranca;

    private StatusPagamento statusPagamento;

    @NotNull(message = "valorPagamento nao pode ser nulo")
    private BigDecimal valorPagamento;
}
