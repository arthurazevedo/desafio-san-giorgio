package com.arthurazevedo.pagamento.infrastructure.messaging;

import com.amazonaws.services.sqs.AmazonSQS;
import com.arthurazevedo.pagamento.domain.messaging.FilaParcialProducer;
import com.arthurazevedo.pagamento.infrastructure.config.properties.PagamentoParcialProperties;
import org.springframework.stereotype.Component;

@Component
public class PagamentoParcialProducer implements FilaParcialProducer {

    private final AmazonSQS amazonSQS;
    private final PagamentoParcialProperties sqsProperties;

    public PagamentoParcialProducer(AmazonSQS amazonSQS, PagamentoParcialProperties sqsProperties) {
        this.amazonSQS = amazonSQS;
        this.sqsProperties = sqsProperties;
    }

    @Override
    public void enviarMensagem(String message) {
        amazonSQS.sendMessage(sqsProperties.getUrl(), message);
    }
}
