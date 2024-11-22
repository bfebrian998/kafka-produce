package com.example.kafka.producer.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafka.producer.dto.request.ProduceDto;
import com.google.gson.Gson;


@Service
public class ProducerKafkaService {
    
    @Value("${spring.kafka.producer.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public String sendKafka(ProduceDto request) {

        Gson gson = new Gson();
        String partition = UUID.randomUUID().toString();
        kafkaTemplate.send(topic,partition, gson.toJson(request));

        return "Message has been produced successfully";

    }

    
}
