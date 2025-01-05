package com.example.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public void registerNewOrder(@RequestBody Order order) {
        orderService.addNewOrder(order);
    }

    @DeleteMapping(path = "{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        orderService.deleteOrder(orderId);
    }


//    private Long id;
//    private String userName;
//    private LocalDateTime orderDate;
//    private Integer totalAmount;
//    private String status;
    @PutMapping(path = "{orderId}")
    public void updateOrder(
            @PathVariable("orderId") Long orderId,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String status
    ) {
        orderService.updateOrder(orderId, userName, status);
    }

}
