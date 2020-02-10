package com.github.padovese.kafka.controller;

import com.github.padovese.kafka.model.SomeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author padovese
 * @since 10/02/2020
 */

@RestController
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, SomeEntity> kafkaTemplate;

    @GetMapping("/{prefix}/{rep}")
    public String produce(@PathVariable(name = "prefix") String prefix, @PathVariable(name = "rep") int rep){
        for(int rept = rep; rept > 0; rept--){
            sendMessage(new SomeEntity(rept, prefix));
        }
        return "ok";
    }

//    To produce simple string messages
//    public void sendMessage(String msg) {
//        kafkaTemplate.send("first_topic", msg);
//    }

//  To produce json
    public void sendMessage(SomeEntity obj) {
        kafkaTemplate.send("first_topic", obj);
    }
}
