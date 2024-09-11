package com.arthurazevedo.pagamento.infrastructure.repository.jpa;

import com.arthurazevedo.pagamento.infrastructure.repository.entity.CobrancaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface CobrancaJpaRepository extends JpaRepository<CobrancaEntity, Long> {
    Optional<CobrancaEntity> getByCodigo(Long codigo);
    //BigDecimal getValorByCodigo(Long codigo);
}
