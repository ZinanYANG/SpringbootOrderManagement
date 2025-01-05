package com.example.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }



    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public void addNewOrder(Order order) {

        Optional<Order> orderOptional = orderRepository.findOrderById(order.getId());
        if (orderOptional.isPresent()) {
            throw new IllegalStateException("Order already exists");
        }
        orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        boolean exists = orderRepository.existsById(orderId);
        if (!exists) {
            throw new IllegalStateException("Order with id " + orderId + " does not exist");
        }
        orderRepository.deleteById(orderId);
    }


    @Transactional
    public void updateOrder(Long orderId,
                            String userName,
                            String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order with id " + orderId + " does not exist"));
        if(userName != null && userName.length()>0 && !Objects.equals(userName, order.getUserName())) {
            order.setUserName(userName);
        }

        if(status != null && status.length()>0 && !Objects.equals(status, order.getStatus())) {
            order.setStatus(status);
        }
    }
}
