package com.arthurazevedo.vendedor.infrastructure.repository.jpa;

import com.arthurazevedo.vendedor.infrastructure.repository.entity.VendedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendedorJpaRepository extends JpaRepository<VendedorEntity, Long> {
    Optional<VendedorEntity> getByCodigo(Long codigo);
}
