package com.example.producerorders.controller;

import com.example.producerorders.kafka.KafkaProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/hello")
public class HelloMessage {

    @Autowired
    private KafkaProducerConfig kafkaProducerConfig;

    @GetMapping
    public ResponseEntity<HashMap<String, String>> getHello(){
        var message = new HashMap<String, String>();
        message.put("message", "Message sent! Check Kafka Drop please");

        this.kafkaProducerConfig.sendMessage("Hello World!!");

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
