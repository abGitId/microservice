package com.example.client2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class Client2Application {

    @Autowired
    private ServiceFeignClient serviceFeignClient;

    @Value("${spring.application.name}")
    private String applicationName;

    public static void main(String[] args) {
        SpringApplication.run(Client2Application.class, args);
    }

    @GetMapping("/client-name")
    public String getClientName() {

        return "Hello from " + applicationName;
    }

    @GetMapping("/client-status")
    public String getClient1Status() {

        return "status= " + serviceFeignClient.getStatus();
    }

    @GetMapping("/user")
    public String getClient1User() {

        return "status= " + serviceFeignClient.getUser();
    }
}
