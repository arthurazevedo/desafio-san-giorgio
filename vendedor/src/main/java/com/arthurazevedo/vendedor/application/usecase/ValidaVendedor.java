package com.arthurazevedo.vendedor.application.usecase;

import com.arthurazevedo.vendedor.application.exception.VendedorNaoEncontradoException;
import com.arthurazevedo.vendedor.domain.repository.VendedorRepository;

public class ValidaVendedor {

    private VendedorRepository vendedorRepository;

    public ValidaVendedor(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public void execute(Long codigoVendedor) {
        vendedorRepository.getByCodigo(codigoVendedor)
                .orElseThrow(() -> new VendedorNaoEncontradoException(codigoVendedor));
    }
}
