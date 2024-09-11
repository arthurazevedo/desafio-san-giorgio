package com.arthurazevedo.pagamento.infrastructure.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "TB_COBRANCA")
public class CobrancaEntity {

    @Id
    private Long codigo;
    private BigDecimal valor;
    private Long codigoVendedor;
}
