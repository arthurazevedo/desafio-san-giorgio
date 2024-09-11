package com.arthurazevedo.pagamento.infrastructure.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.arthurazevedo.pagamento.infrastructure.config.properties.SqsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqsConfiguration {

    @Autowired
    private SqsProperties propriedadesSQS;

    @Bean
    public AmazonSQS amazonSQS() {

        BasicAWSCredentials awsCredencial = new BasicAWSCredentials(propriedadesSQS.getChaveAcesso(), propriedadesSQS.getChaveSecreta());

        return AmazonSQSClientBuilder.standard()
                .withRegion(propriedadesSQS.getRegiao())
                .withCredentials(new AWSStaticCredentialsProvider(awsCredencial))
                .build();
    }
}
