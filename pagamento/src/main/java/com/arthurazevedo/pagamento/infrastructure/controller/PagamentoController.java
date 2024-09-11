package com.arthurazevedo.pagamento.infrastructure.controller;

import com.arthurazevedo.pagamento.application.usecase.ValidaCobranca;
import com.arthurazevedo.pagamento.domain.model.Cobranca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoController {

    @Autowired
    private ValidaCobranca validaCobranca;

    @GetMapping("/valida/{codigo}")
    public ResponseEntity<Cobranca> validaCobranca(@PathVariable("codigo") Long codigo) {
        return ResponseEntity.ok(validaCobranca.execute(codigo));
    }
}
