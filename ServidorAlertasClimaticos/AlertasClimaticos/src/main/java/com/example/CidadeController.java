package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public String cadastrarCidade(@RequestBody String cidade) {
        kafkaTemplate.send("cidade-topic", cidade);
        return "Cidade cadastrada com sucesso!";
    }
}
