package com.example.demo.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class OrderConfig {
    @Bean
    CommandLineRunner commandLineRunner(OrderRepository repository) {
        return args -> {
            Order order1 = new Order(
                    "John Doe", // userName
                    LocalDateTime.of(2023, 12, 25, 15, 30), // orderDate
                    100, // totalAmount
                    "Pending" // status
            );

            Order order2 = new Order(
                    "Jane Smith", // userName
                    LocalDateTime.of(2024, 1, 15, 10, 0), // orderDate
                    250, // totalAmount
                    "Completed" // status
            );

            repository.saveAll(
                    List.of(order1, order2)
            );


        };
    }
}
