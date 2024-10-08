package com.arthurazevedo.orquestrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OrquestradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrquestradorApplication.class, args);
	}

}
