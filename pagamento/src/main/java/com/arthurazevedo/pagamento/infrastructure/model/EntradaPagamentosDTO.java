package com.arthurazevedo.pagamento.infrastructure.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
public class EntradaPagamentosDTO {

    @NotNull(message = "codigoVendedor nao pode ser nulo")
    private Long codigoVendedor;

    @NotNull(message = "pagamentos nao pode ser nulo")
    @NotEmpty(message = "lista de pagamentos nao pode ser vazia")
    @Valid
    private List<PagamentoDTO> pagamentos;
}
