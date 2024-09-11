package com.arthurazevedo.pagamento.infrastructure.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aws.sqs.endpoints.pagamento-excedente")
public class PagamentoExcedenteProperties {
    private String url;
}
