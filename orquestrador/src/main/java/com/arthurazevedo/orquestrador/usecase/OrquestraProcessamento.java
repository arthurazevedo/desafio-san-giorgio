package com.arthurazevedo.orquestrador.usecase;

import com.arthurazevedo.orquestrador.client.PagamentoClient;
import com.arthurazevedo.orquestrador.client.VendedorClient;
import com.arthurazevedo.orquestrador.model.EntradaPagamentosDTO;
import com.arthurazevedo.orquestrador.model.ValidacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrquestraProcessamento {

    private final PagamentoClient pagamentoClient;

    private final VendedorClient vendedorClient;

    public EntradaPagamentosDTO execute(EntradaPagamentosDTO entradaPagamentos) {

        ValidacaoDTO validacaoVendedor = vendedorClient.validaVendedor(entradaPagamentos.getCodigoVendedor());

        if (validacaoVendedor.getStatus() == 200) {
            return pagamentoClient.processaPagamento(entradaPagamentos);
        }

        throw new RuntimeException("ZORRA");
    }
}
