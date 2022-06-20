package com.example.consumerorders.listener;

import com.example.consumerorders.model.Order;
import com.example.consumerorders.model.OrderReceived;
import com.example.consumerorders.service.OrderService;
import com.example.consumerorders.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Log4j2
@Service
public class KafkaOrderListener {

    @KafkaListener(topics = "${topic.shop-client}", groupId = "${spring.kafka.consumer.group-id}")
    public void getMessage(String message) throws JsonMappingException, JsonProcessingException {
        log.info("New message received: {}", message);

        // convertendo a mensagem com o objeto para o modelo
        ObjectMapper mapper = new ObjectMapper();
        var orderReceived = mapper.readValue(message, OrderReceived.class);

        //utilizando os dados para criar o pedido com o método criado abaixo
        var order = this.newOrder(orderReceived);
        log.info("New Order created: {}", order);

        // passando o pedido para a lista no service
        OrderService.orders.add(order);
    }

    public Order newOrder(OrderReceived orderReceived){
        var order = new Order();
        BeanUtils.copyProperties(orderReceived, order);
        order.setId(UUID.randomUUID().toString());
        order.setCreated_at(LocalDateTime.now());
        var product = ProductService.getById(orderReceived.getProductId());
        order.setProductName(product.getName());
        order.setPriceTotal(orderReceived.getQuantity() * product.getPrice());
        return order;
    }


}
