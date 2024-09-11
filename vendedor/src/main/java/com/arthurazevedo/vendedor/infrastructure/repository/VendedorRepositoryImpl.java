package com.arthurazevedo.vendedor.infrastructure.repository;

import com.arthurazevedo.vendedor.domain.model.Vendedor;
import com.arthurazevedo.vendedor.domain.repository.VendedorRepository;
import com.arthurazevedo.vendedor.infrastructure.mapper.VendedorMapper;
import com.arthurazevedo.vendedor.infrastructure.repository.jpa.VendedorJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VendedorRepositoryImpl implements VendedorRepository {

    private final VendedorJpaRepository repositorio;

    private static final VendedorMapper vendedorMapper = VendedorMapper.INSTANCE;

    @Override
    public Optional<Vendedor> getByCodigo(Long codigoVendedor) {
        return repositorio.getByCodigo(codigoVendedor).map(vendedorMapper::toVendedor);
    }
}
