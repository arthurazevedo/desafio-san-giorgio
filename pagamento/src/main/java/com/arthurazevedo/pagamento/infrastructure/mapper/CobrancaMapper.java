package com.arthurazevedo.pagamento.infrastructure.mapper;

import com.arthurazevedo.pagamento.domain.model.Cobranca;
import com.arthurazevedo.pagamento.infrastructure.repository.entity.CobrancaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CobrancaMapper {

    CobrancaMapper INSTANCE = Mappers.getMapper(CobrancaMapper.class);

    Cobranca cobrancaEntityToCobranca(CobrancaEntity entidade);
}
