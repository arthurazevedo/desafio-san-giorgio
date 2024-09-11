package com.arthurazevedo.pagamento.infrastructure.controller;

import com.arthurazevedo.pagamento.application.usecase.ProcessaPagamento;
import com.arthurazevedo.pagamento.domain.model.EntradaPagamento;
import com.arthurazevedo.pagamento.infrastructure.mapper.EntradaPagamentoMapper;
import com.arthurazevedo.pagamento.infrastructure.model.EntradaPagamentosDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
@RequiredArgsConstructor
public class PagamentoController {

    private final ProcessaPagamento processaPagamento;
    private static final EntradaPagamentoMapper entradaPagamentoMapper = EntradaPagamentoMapper.INSTANCE;

    @PostMapping("/processa")
    public ResponseEntity<EntradaPagamentosDTO> validaCobranca(@RequestBody @Valid EntradaPagamentosDTO entradaPagamentos) {

        EntradaPagamento retorno = processaPagamento.execute(entradaPagamentoMapper.toEntradaPagamento(entradaPagamentos));

        return ResponseEntity.ok(entradaPagamentoMapper.toEntradaPagamentoDTO(retorno));
    }
}
