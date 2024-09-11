package com.arthurazevedo.pagamento.infrastructure.repository;

import com.arthurazevedo.pagamento.domain.model.Cobranca;
import com.arthurazevedo.pagamento.domain.repository.CobrancaRepository;
import com.arthurazevedo.pagamento.infrastructure.mapper.CobrancaMapper;
import com.arthurazevedo.pagamento.infrastructure.repository.jpa.CobrancaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CobrancaRepositoryImpl implements CobrancaRepository {

    private final CobrancaJpaRepository repositorio;
    private static final CobrancaMapper cobrancaMapper = CobrancaMapper.INSTANCE;

    @Override
    public Optional<Cobranca> getByCodigo(Long codigo) {
        return repositorio.getByCodigo(codigo).map(cobrancaMapper::cobrancaEntityToCobranca);
    }

    @Override
    public BigDecimal getValorByCodigo(Long codigo) {
        return null;
    }
}
