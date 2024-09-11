package com.arthurazevedo.vendedor.infrastructure.config;

import com.arthurazevedo.vendedor.application.usecase.ValidaVendedor;
import com.arthurazevedo.vendedor.domain.repository.VendedorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ValidaVendedor validaVendedor(VendedorRepository vendedorRepository) {
        return new ValidaVendedor(vendedorRepository);
    }
}
