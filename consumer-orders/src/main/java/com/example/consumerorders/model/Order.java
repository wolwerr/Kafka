package com.example.consumerorders.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {

    private String id;
    private String clientName;
    private String productName;
    private Integer quantity;
    private Double priceTotal;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime created_at;
}
