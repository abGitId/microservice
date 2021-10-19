package com.example.esurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EsurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsurekaserverApplication.class, args);
	}

}
