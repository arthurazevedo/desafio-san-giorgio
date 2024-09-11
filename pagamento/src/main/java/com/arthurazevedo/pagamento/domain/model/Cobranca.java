package com.arthurazevedo.pagamento.domain.model;

import java.math.BigDecimal;

public class Cobranca {
    private Long codigo;
    private BigDecimal valor;

    public Cobranca() {}

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
