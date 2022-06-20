package com.example.producerorders.controller;

import com.example.producerorders.model.Order;
import com.example.producerorders.services.OrederService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrederService orederService;

    @PostMapping
    public ResponseEntity<HashMap<String, String>> saveOrder(@RequestBody Order order) throws JsonProcessingException{
        return new ResponseEntity<>(this.orederService.create(order), HttpStatus.CREATED);
    }
}
