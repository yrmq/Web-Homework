package org.example.microservice.controller;

import org.example.microservice.entity.AdviceEntity;
import org.example.microservice.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdviceController {
    @Autowired
    private AdviceRepository adviceRepository;

    @GetMapping("/advices")
    public List<AdviceEntity> listAdvices(){
        return adviceRepository.findAll();
    }

    @PostMapping("/advices")
    public AdviceEntity createAdvice(@RequestParam(value = "title", required = false) String title,
                                     @RequestBody AdviceEntity advice){
        return adviceRepository.save(advice);
    }
}
