package com.arthurazevedo.pagamento.infrastructure.messaging;

import com.amazonaws.services.sqs.AmazonSQS;
import com.arthurazevedo.pagamento.domain.messaging.Producer;
import com.arthurazevedo.pagamento.infrastructure.config.properties.PagamentoExcedenteProperties;
import org.springframework.stereotype.Component;

@Component
public class PagamentoExcedenteProducer implements Producer {

    private final AmazonSQS amazonSQS;
    private final PagamentoExcedenteProperties sqsProperties;

    public PagamentoExcedenteProducer(AmazonSQS amazonSQS, PagamentoExcedenteProperties sqsProperties) {
        this.amazonSQS = amazonSQS;
        this.sqsProperties = sqsProperties;
    }

    @Override
    public void enviarMensagem(String message) {
        amazonSQS.sendMessage(sqsProperties.getUrl(), message);
    }
}
