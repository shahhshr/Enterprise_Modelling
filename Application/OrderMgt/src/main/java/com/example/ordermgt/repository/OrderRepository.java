package com.example.ordermgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ordermgt.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}