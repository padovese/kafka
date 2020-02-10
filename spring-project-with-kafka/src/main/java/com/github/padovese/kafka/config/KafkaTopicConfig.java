package com.github.padovese.kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author padovese
 * @since 10/02/2020
 */

@Configuration
public class KafkaTopicConfig {

    @Value(value = "localhost:29092")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

//    In case you want to create a new topic
//    @Bean
//    public NewTopic topic1() {
//        return new NewTopic("second_topic", 3, (short) 2);
//    }
}