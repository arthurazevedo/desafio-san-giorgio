package com.arthurazevedo.pagamento.domain.repository;

import com.arthurazevedo.pagamento.domain.model.Cobranca;

import java.util.Optional;

public interface CobrancaRepository {
    Optional<Cobranca> getByCodigoAndVendedor(Long codigo, Long codigoVendedor);
}
