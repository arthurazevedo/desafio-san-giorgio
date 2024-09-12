package com.arthurazevedo.orquestrador.client;

import com.arthurazevedo.orquestrador.model.ValidacaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vendedor", url = "http://vendedor:8081")
public interface VendedorClient {
    @GetMapping("/vendedor/valida/{codigoVendedor}")
    ValidacaoDTO validaVendedor(@PathVariable("codigoVendedor") Long id);
}
