package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class, args);
    }

    @GetMapping("/hello")
    @CircuitBreaker(name = "helloService", fallbackMethod = "fallbackHello")
    public String hello() {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Случайная ошибка");
        }
        return "Привет из Service A!";
    }

    public String fallbackHello(Throwable t) {
        return "Service A временно недоступен. Причина: " + t.getMessage();
    }
}
