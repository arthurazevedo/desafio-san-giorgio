package com.arthurazevedo.orquestrador.usecase;

import com.arthurazevedo.orquestrador.client.PagamentoClient;
import com.arthurazevedo.orquestrador.client.VendedorClient;
import com.arthurazevedo.orquestrador.controller.exceptionhandler.ErroInternoException;
import com.arthurazevedo.orquestrador.model.EntradaPagamentosDTO;
import com.arthurazevedo.orquestrador.model.ValidacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrquestraProcessamento {

    private static final int STATUS_VALIDO = 200;

    private final PagamentoClient pagamentoClient;

    private final VendedorClient vendedorClient;

    public EntradaPagamentosDTO execute(EntradaPagamentosDTO entradaPagamentos) {

        ValidacaoDTO validacaoVendedor = vendedorClient.validaVendedor(entradaPagamentos.getCodigoVendedor());

        if (validacaoVendedor.getStatus() == STATUS_VALIDO) {
            return pagamentoClient.processaPagamento(entradaPagamentos);
        }

        throw new ErroInternoException();
    }
}
