package com.arthurazevedo.pagamento.infrastructure.config;

import com.arthurazevedo.pagamento.application.usecase.ProcessaPagamento;
import com.arthurazevedo.pagamento.application.usecase.ValidaCobranca;
import com.arthurazevedo.pagamento.application.usecase.PagamentoSQSProcessor;
import com.arthurazevedo.pagamento.domain.repository.CobrancaRepository;
import com.arthurazevedo.pagamento.infrastructure.messaging.PagamentoExcedenteProducer;
import com.arthurazevedo.pagamento.infrastructure.messaging.PagamentoParcialProducer;
import com.arthurazevedo.pagamento.infrastructure.messaging.PagamentoTotalProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PagamentoSQSProcessor pagamentoProcessor(PagamentoParcialProducer pagamentoParcialProducer,
                                                    PagamentoExcedenteProducer pagamentoExcedenteProducer,
                                                    PagamentoTotalProducer pagamentoTotalProducer) {
        return new PagamentoSQSProcessor(pagamentoParcialProducer, pagamentoTotalProducer, pagamentoExcedenteProducer);
    }
    @Bean
    public ValidaCobranca validaCobranca(CobrancaRepository cobrancaRepository) {
        return new ValidaCobranca(cobrancaRepository);
    }

    @Bean
    public ProcessaPagamento processaPagamento(CobrancaRepository cobrancaRepository, ValidaCobranca validaCobranca,
                                               PagamentoSQSProcessor processador) {
        return new ProcessaPagamento(cobrancaRepository, validaCobranca, processador);
    }
}
