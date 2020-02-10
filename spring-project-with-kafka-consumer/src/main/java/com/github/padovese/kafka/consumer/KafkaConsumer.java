package com.github.padovese.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.padovese.kafka.model.SomeEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author padovese
 * @since 10/02/2020
 */

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "first_topic", groupId = "java-app")
    public void listen(String message) throws JsonProcessingException {
        SomeEntity obj = new ObjectMapper().readValue(message, SomeEntity.class);
        System.out.println("Received Messasge: " + obj);
    }

}
