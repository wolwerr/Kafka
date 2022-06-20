package com.example.producerorders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ProducerOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerOrdersApplication.class, args);
	}

}
