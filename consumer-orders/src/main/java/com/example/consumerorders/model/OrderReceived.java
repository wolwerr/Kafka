package com.example.consumerorders.model;

import lombok.Data;

@Data
public class OrderReceived {

    private String id;
    private String clientName;
    private String clientCPF;
    private Integer ProductId;
    private Integer quantity;

}
