package com.arthurazevedo.pagamento.application.usecase;

import com.arthurazevedo.pagamento.application.exception.CobrancaNaoEncontradaException;
import com.arthurazevedo.pagamento.domain.model.Cobranca;
import com.arthurazevedo.pagamento.domain.repository.CobrancaRepository;

public class ValidaCobranca {

    private CobrancaRepository cobrancaRepository;

    public ValidaCobranca(CobrancaRepository cobrancaRepository) {
        this.cobrancaRepository = cobrancaRepository;
    }

    public Cobranca execute(Long codigoCobranca) {
        return cobrancaRepository.getByCodigo(codigoCobranca).orElseThrow(() -> new CobrancaNaoEncontradaException(codigoCobranca));
    }
}
