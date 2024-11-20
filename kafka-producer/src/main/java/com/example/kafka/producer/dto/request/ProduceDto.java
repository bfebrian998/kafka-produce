package com.example.kafka.producer.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduceDto {
    private String name;
    private String message;
}
