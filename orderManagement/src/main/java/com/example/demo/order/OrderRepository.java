package com.example.demo.order;

import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

//    @Query("SELECT o FROM Order o WHERE o.userName = ?1")
//    Optional<Order> findOrderByUserName(String userName);

//    @Query("SELECT o FROM Order o WHERE o.id = ?1")
    Optional<Order> findOrderById(Long id);

}
