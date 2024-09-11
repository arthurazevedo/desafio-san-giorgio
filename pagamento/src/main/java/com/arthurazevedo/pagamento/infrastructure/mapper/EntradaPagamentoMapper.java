package com.arthurazevedo.pagamento.infrastructure.mapper;

import com.arthurazevedo.pagamento.domain.model.EntradaPagamento;
import com.arthurazevedo.pagamento.infrastructure.model.EntradaPagamentosDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntradaPagamentoMapper {
    EntradaPagamentoMapper INSTANCE = Mappers.getMapper(EntradaPagamentoMapper.class);

    EntradaPagamento toEntradaPagamento(EntradaPagamentosDTO dto);
    EntradaPagamentosDTO toEntradaPagamentoDTO(EntradaPagamento entradaPagamento);
}
