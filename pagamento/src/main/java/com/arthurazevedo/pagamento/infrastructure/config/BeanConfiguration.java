package com.arthurazevedo.pagamento.infrastructure.config;

import com.arthurazevedo.pagamento.application.usecase.ProcessaPagamento;
import com.arthurazevedo.pagamento.application.usecase.ValidaCobranca;
import com.arthurazevedo.pagamento.domain.repository.CobrancaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ValidaCobranca validaCobranca(CobrancaRepository cobrancaRepository) {
        return new ValidaCobranca(cobrancaRepository);
    }

    @Bean
    public ProcessaPagamento processaPagamento(CobrancaRepository cobrancaRepository) {
        return new ProcessaPagamento(cobrancaRepository);
    }
}
