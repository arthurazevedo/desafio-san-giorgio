package com.arthurazevedo.pagamento.domain.model;

import java.util.List;

public class EntradaPagamento {

    private Long codigoVendedor;
    private List<Pagamento> pagamentos;

    public EntradaPagamento(Long codigoVendedor, List<Pagamento> pagamentos) {
        this.codigoVendedor = codigoVendedor;
        this.pagamentos = pagamentos;
    }

    public Long getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Long codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }
}
