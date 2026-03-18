package com.example.ordermgt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.ordermgt.entity.Order;
import com.example.ordermgt.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public Order saveOrder(Order order) {
        return repo.save(order);
    }

    public List<Order> getAllOrders() {
        return repo.findAll();
    }
    
    public Order getOrderById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrder(Long id) {
        repo.deleteById(id);
    }
}