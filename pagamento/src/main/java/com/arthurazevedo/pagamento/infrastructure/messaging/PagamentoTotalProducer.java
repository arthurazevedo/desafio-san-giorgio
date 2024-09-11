package com.arthurazevedo.pagamento.infrastructure.messaging;

import com.amazonaws.services.sqs.AmazonSQS;
import com.arthurazevedo.pagamento.domain.messaging.FilaTotalProducer;
import com.arthurazevedo.pagamento.infrastructure.config.properties.PagamentoTotalProperties;
import org.springframework.stereotype.Component;

@Component
public class PagamentoTotalProducer implements FilaTotalProducer {

    private final AmazonSQS amazonSQS;
    private final PagamentoTotalProperties sqsProperties;

    public PagamentoTotalProducer(AmazonSQS amazonSQS, PagamentoTotalProperties sqsProperties) {
        this.amazonSQS = amazonSQS;
        this.sqsProperties = sqsProperties;
    }

    @Override
    public void enviarMensagem(String message) {
        amazonSQS.sendMessage(sqsProperties.getUrl(), message);
    }
}
