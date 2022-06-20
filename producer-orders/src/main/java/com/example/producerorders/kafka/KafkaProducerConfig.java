package com.example.producerorders.kafka;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaProducerConfig {

    @Value("${topic.shop-client}")
    private String topicShopClient;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){

        //Envia mensagem par ao topic criado
        this.kafkaTemplate.send(topicShopClient, message);
        log.info("Sending message to the topic_shop_client: {}", message);
    }
}
