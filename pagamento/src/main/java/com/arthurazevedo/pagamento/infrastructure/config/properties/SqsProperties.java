package com.arthurazevedo.pagamento.infrastructure.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aws.sqs")
public class SqsProperties {
    private String regiao;
    private String chaveAcesso;
    private String chaveSecreta;
}
