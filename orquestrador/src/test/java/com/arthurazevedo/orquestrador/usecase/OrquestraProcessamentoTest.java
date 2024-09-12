package com.arthurazevedo.orquestrador.usecase;

import com.arthurazevedo.orquestrador.client.PagamentoClient;
import com.arthurazevedo.orquestrador.client.VendedorClient;
import com.arthurazevedo.orquestrador.controller.exceptionhandler.ErroInternoException;
import com.arthurazevedo.orquestrador.model.EntradaPagamentosDTO;
import com.arthurazevedo.orquestrador.model.PagamentoDTO;
import com.arthurazevedo.orquestrador.model.ValidacaoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class OrquestraProcessamentoTest {

    @InjectMocks
    private OrquestraProcessamento orquestraProcessamento;
    @Mock
    private PagamentoClient pagamentoClient;
    @Mock
    private VendedorClient vendedorClient;

    private Long codigoVendedor = 1L;
    private ValidacaoDTO validacao;
    private EntradaPagamentosDTO entradaPagamentosDTO;

    @BeforeEach
    void setUp() {
        validacao = new ValidacaoDTO();
        validacao.setStatus(200);

        entradaPagamentosDTO = new EntradaPagamentosDTO();
        entradaPagamentosDTO.setCodigoVendedor(codigoVendedor);
        entradaPagamentosDTO.setPagamentos(List.of(new PagamentoDTO()));
    }

    @Test
    void orquestraComSucesso() {
        when(vendedorClient.validaVendedor(codigoVendedor)).thenReturn(validacao);
        when(pagamentoClient.processaPagamento(entradaPagamentosDTO)).thenReturn(entradaPagamentosDTO);

        assertDoesNotThrow(() -> orquestraProcessamento.execute(entradaPagamentosDTO));
    }

    @Test
    void orquestraComErroInterno() {
        validacao.setStatus(400);

        when(vendedorClient.validaVendedor(codigoVendedor)).thenReturn(validacao);

        assertThrows(ErroInternoException.class, () -> orquestraProcessamento.execute(entradaPagamentosDTO));
    }
}
