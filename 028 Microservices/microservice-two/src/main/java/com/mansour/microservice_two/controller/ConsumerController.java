package com.mansour.microservice_two.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/messages-two")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getMessage() {
        return restTemplate.getForObject("http://localhost:8081/api/v1/messages", String.class) + " through Microservice two.";

    }

}
