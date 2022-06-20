package com.example.consumerorders.service;

import com.example.consumerorders.model.Order;
import com.example.consumerorders.model.OrderReceived;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    public static List<Order> orders = new ArrayList<>();

    public List<Order> getOrders(){
        return orders;
    }
}
