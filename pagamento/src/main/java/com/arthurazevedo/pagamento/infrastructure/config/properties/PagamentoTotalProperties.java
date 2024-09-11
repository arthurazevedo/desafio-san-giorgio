package com.arthurazevedo.pagamento.infrastructure.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aws.sqs.endpoints.pagamento-total")
public class PagamentoTotalProperties {
    private String url;
}
