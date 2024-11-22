package com.example.kafka.producer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.producer.dto.request.ProduceDto;
import com.example.kafka.producer.service.ProducerKafkaService;

@RestController
@RequestMapping("/producer")
public class ProducerKafka {

   
    private ProducerKafkaService producerKafkaService;

    public ProducerKafka(ProducerKafkaService producerKafkaService) {
        this.producerKafkaService = producerKafkaService;
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/send-data")
    public ResponseEntity<String> produceMessage(@RequestBody ProduceDto reqDto) {

        String value = producerKafkaService.sendKafka(reqDto);

        return ResponseEntity.ok().body(value);
    }
    
}
