package com.arthurazevedo.vendedor.infrastructure.controller;

import com.arthurazevedo.vendedor.application.usecase.ValidaVendedor;
import com.arthurazevedo.vendedor.infrastructure.model.ValidacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/vendedor")
@RequiredArgsConstructor
public class VendedorController {

    private static final String MENSAGEM_SUCESSO = "VENDEDOR VALIDADO COM SUCESSO";
    private final ValidaVendedor validaVendedor;

    @GetMapping("/valida/{codigoVendedor}")
    public ResponseEntity<ValidacaoDTO> validaVendedor(@PathVariable("codigoVendedor") Long codigoVendedor) {

        validaVendedor.execute(codigoVendedor);
        return ResponseEntity.ok(ValidacaoDTO.builder()
                .status(OK.value())
                .mensagem(MENSAGEM_SUCESSO)
                .build());
    }
}
