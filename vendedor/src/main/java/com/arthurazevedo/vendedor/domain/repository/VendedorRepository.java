package com.arthurazevedo.vendedor.domain.repository;

import com.arthurazevedo.vendedor.domain.model.Vendedor;

import java.util.Optional;

public interface VendedorRepository {
    Optional<Vendedor> getByCodigo(Long codigoVendedor);
}
