package com.example.producerorders.model;

import lombok.Data;

@Data
public class Order {

    private String id;
    private String clientName;
    private String clientCPF;
    private Integer ProductId;
    private Integer quantity;
}
