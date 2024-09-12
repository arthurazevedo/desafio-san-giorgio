package com.arthurazevedo.pagamento.application.usecase;

import com.arthurazevedo.pagamento.application.exception.CobrancaNaoEncontradaException;
import com.arthurazevedo.pagamento.domain.model.Cobranca;
import com.arthurazevedo.pagamento.domain.model.Pagamento;
import com.arthurazevedo.pagamento.domain.repository.CobrancaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class ValidaCobrancaTest {

    @InjectMocks
    private ValidaCobranca validaCobranca;

    @Mock
    private CobrancaRepository cobrancaRepository;

    private Long codigoVendedor = 1L;
    private Pagamento pagamento;

    @BeforeEach
    void setUp() {
        pagamento = new Pagamento(1L, null, BigDecimal.valueOf(2.4));
    }

    @Test
    void validaComSucesso() {

        when(cobrancaRepository.getByCodigoAndVendedor(codigoVendedor, pagamento.getCodigoCobranca()))
                .thenReturn(Optional.of(new Cobranca()));
        assertDoesNotThrow(() -> validaCobranca.execute(codigoVendedor, pagamento));
    }

    @Test
    void validaComFalha() {

        when(cobrancaRepository.getByCodigoAndVendedor(codigoVendedor, pagamento.getCodigoCobranca()))
                .thenReturn(Optional.empty());
        assertThrows(CobrancaNaoEncontradaException.class, () -> validaCobranca.execute(codigoVendedor, pagamento));
    }
}
