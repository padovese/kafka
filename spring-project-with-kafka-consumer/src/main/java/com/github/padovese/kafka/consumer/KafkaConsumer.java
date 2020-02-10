package com.github.padovese.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author padovese
 * @since 10/02/2020
 */

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "first_topic", groupId = "java-app")
    public void listen(String message) {
        System.out.println("Received Messasge: " + message);
    }

}
