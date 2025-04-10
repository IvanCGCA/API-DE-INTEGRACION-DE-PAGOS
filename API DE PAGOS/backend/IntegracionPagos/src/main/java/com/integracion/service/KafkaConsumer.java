package com.integracion.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    // Escucha mensajes del topic "test_topic"
    @KafkaListener(topics = "test_topic", groupId = "grupo1")
    public void consume(String message) {
        System.out.println("Mensaje recibido: " + message);
    }
}