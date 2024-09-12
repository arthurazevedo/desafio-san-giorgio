package com.arthurazevedo.orquestrador.controller;

import com.arthurazevedo.orquestrador.model.EntradaPagamentosDTO;
import com.arthurazevedo.orquestrador.usecase.OrquestraProcessamento;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orquestrador")
@RequiredArgsConstructor
public class OrquestraProcessamentoController {

    private final OrquestraProcessamento orquestraProcessamento;

    @PostMapping("/processa")
    public ResponseEntity<EntradaPagamentosDTO> processaPagamento(@RequestBody @Valid EntradaPagamentosDTO entradaPagamentos) {
        return ResponseEntity.ok(orquestraProcessamento.execute(entradaPagamentos));
    }
}
