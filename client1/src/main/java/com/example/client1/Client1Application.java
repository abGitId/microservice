package com.example.client1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class Client1Application {

    @Value("${client1.greetings}")
    private String greetingMsg;

    public static void main(String[] args) {
        SpringApplication.run(Client1Application.class, args);
    }

    @GetMapping("/status")
    public String getStatus() {
        return "Client1 service is up and running...";
    }

    @GetMapping("/greetings")
    public String greetings() {
        return greetingMsg;
    }

    @GetMapping("/mock-user-details")
    public ResponseEntity<User> getMockUserDetails() {
        return ResponseEntity.of(Optional.ofNullable(User.getMockUser()));
    }
}


@Data
class User {
    private String name;
    private String city;
    private int age;

    public static User getMockUser(){
        User user = new User();
        user.setName("foo");
        user.setCity("Pune");
        user.setAge(30);
        return user;
    }
}