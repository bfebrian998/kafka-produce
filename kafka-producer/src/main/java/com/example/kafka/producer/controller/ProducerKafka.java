package com.example.kafka.producer.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.producer.dto.request.ProduceDto;
import com.google.gson.Gson;

@RestController
@RequestMapping("/producer")
public class ProducerKafka {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${spring.kafka.producer.topic}")
    private String topic;

    @SuppressWarnings("unchecked")
    @PostMapping("/send-data")
    public String produceMessage(@RequestBody ProduceDto reqDto) {
        Gson gson = new Gson();
        String partition = UUID.randomUUID().toString();
        kafkaTemplate.send(topic,partition, gson.toJson(reqDto));

        return "Message has been produced successfully";
    }
    
}
