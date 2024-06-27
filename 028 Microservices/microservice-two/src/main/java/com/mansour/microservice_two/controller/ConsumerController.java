package com.mansour.microservice_two.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/messages-two")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @GetMapping
    public String getMessage() {
        return circuitBreakerFactory.create("getMessage()")
                .run(() -> restTemplate.getForObject("http://localhost:8081/api/v1/messages", String.class)
                        + " through Microservice two.", throwable -> fallback(throwable));

    }

    private String fallback(Throwable throwable) {
        return "Default message due to this error from calling microservice-one: %s".formatted(throwable.getMessage());
    }

}
