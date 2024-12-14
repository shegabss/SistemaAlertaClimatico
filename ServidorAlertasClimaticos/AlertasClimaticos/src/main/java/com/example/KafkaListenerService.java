package com.example;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {

    // Consumindo as mensagens do tópico "cidade-topic"
    @KafkaListener(topics = "cidade-topic", groupId = "alerta-climatico")
    public void listen(String message) {
        System.out.println("Mensagem recebida: " + message);
        // Aqui você pode adicionar a lógica para salvar dados ou alterar o banco de dados
    }
}
