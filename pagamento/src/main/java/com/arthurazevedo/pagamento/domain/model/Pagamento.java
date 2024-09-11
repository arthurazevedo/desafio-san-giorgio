package com.arthurazevedo.pagamento.domain.model;

import com.arthurazevedo.pagamento.domain.model.enums.StatusPagamento;

import java.math.BigDecimal;

public class Pagamento {
    private Long codigoCobranca;
    private StatusPagamento statusPagamento;
    private BigDecimal valorPagamento;

    public Pagamento(Long codigoCobranca, StatusPagamento statusPagamento, BigDecimal valorPagamento) {
        this.codigoCobranca = codigoCobranca;
        this.statusPagamento = statusPagamento;
        this.valorPagamento = valorPagamento;
    }

    public Long getCodigoCobranca() {
        return codigoCobranca;
    }

    public void setCodigoCobranca(Long codigoCobranca) {
        this.codigoCobranca = codigoCobranca;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public BigDecimal getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(BigDecimal valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"codigoCobranca\":").append(codigoCobranca).append(",");
        sb.append("\"statusPagamento\":\"").append(statusPagamento).append("\",");
        sb.append("\"valorPagamento\":").append(valorPagamento);
        sb.append("}");
        return sb.toString();
    }
}
