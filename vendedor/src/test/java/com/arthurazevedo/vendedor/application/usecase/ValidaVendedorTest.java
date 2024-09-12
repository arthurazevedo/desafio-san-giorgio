package com.arthurazevedo.vendedor.application.usecase;

import com.arthurazevedo.vendedor.application.exception.VendedorNaoEncontradoException;
import com.arthurazevedo.vendedor.domain.model.Vendedor;
import com.arthurazevedo.vendedor.domain.repository.VendedorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class ValidaVendedorTest {

    @InjectMocks
    private ValidaVendedor validaVendedor;
    @Mock
    private VendedorRepository vendedorRepository;

    private Long codigoVendedor = 1L;

    @Test
    void executaComSucesso() {
        when(vendedorRepository.getByCodigo(codigoVendedor)).thenReturn(Optional.of(new Vendedor()));
        assertDoesNotThrow(() -> validaVendedor.execute(codigoVendedor));
    }

    @Test
    void executaComErro() {
        when(vendedorRepository.getByCodigo(codigoVendedor)).thenReturn(Optional.empty());
        assertThrows(VendedorNaoEncontradoException.class, () -> validaVendedor.execute(codigoVendedor));
    }
}
