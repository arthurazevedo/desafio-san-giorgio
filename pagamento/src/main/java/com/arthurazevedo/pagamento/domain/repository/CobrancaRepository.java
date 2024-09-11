package com.arthurazevedo.pagamento.domain.repository;

import com.arthurazevedo.pagamento.domain.model.Cobranca;

import java.math.BigDecimal;
import java.util.Optional;

public interface CobrancaRepository {
    Optional<Cobranca> getByCodigo(Long codigo);

    BigDecimal getValorByCodigo(Long codigo);
}
