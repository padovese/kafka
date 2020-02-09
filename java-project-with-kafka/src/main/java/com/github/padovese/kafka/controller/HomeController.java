package com.github.padovese.kafka.controller;

import com.github.padovese.kafka.config.KafkaConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author padovese
 * @since 02/02/2020
 */

@RestController
public class HomeController {

    @Autowired
    private KafkaConfig kafkaConfig;

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/{prefix}/{rep}")
    public String home(@PathVariable(name = "prefix") String prefix, @PathVariable(name = "rep") int rep) throws InterruptedException {

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(kafkaConfig.properties());

        for(int rept = rep; rept > 0; rept--){

            ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", prefix + rept);
            producer.send(record);
            producer.flush();
            logger.info(prefix + rept, "ok");
        }

        producer.close();

        return "ok";
    }
}
