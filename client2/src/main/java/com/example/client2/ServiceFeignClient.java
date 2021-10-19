package com.example.client2;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "client1")
//@FeignClient(name = "client1", url = "http://localhost:8081/")
public interface ServiceFeignClient {

    @GetMapping("/status")
    public String getStatus();

    @GetMapping("/mock-user-details")
    public User getUser();
}
