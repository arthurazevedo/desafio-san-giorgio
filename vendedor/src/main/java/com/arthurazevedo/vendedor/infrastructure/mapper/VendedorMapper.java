package com.arthurazevedo.vendedor.infrastructure.mapper;

import com.arthurazevedo.vendedor.domain.model.Vendedor;
import com.arthurazevedo.vendedor.infrastructure.repository.entity.VendedorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendedorMapper {

    VendedorMapper INSTANCE = Mappers.getMapper(VendedorMapper.class);

    Vendedor toVendedor(VendedorEntity entidade);
}
