package com.arthurazevedo.orquestrador.client;

import com.arthurazevedo.orquestrador.model.EntradaPagamentosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pagamento", url = "http://pagamento:8082")
public interface PagamentoClient {
    @PostMapping("/pagamento/processa")
    EntradaPagamentosDTO processaPagamento(@RequestBody EntradaPagamentosDTO entradaPagamento);
}
