package org.example.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AdviceController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/api/advices")
    public Object findAll() {
        return this.restTemplate.getForObject("http://advice-collection-microservice/advices", Object.class);
    }
}
