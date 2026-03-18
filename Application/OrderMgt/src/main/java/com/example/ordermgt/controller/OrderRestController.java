package com.example.ordermgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.ordermgt.entity.Order;
import com.example.ordermgt.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    @Autowired
    private OrderService service;

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order) {
        return service.saveOrder(order);
    }

    @GetMapping("/all")
    public List<Order> getOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {

        Order existing = service.getOrderById(id);

        existing.setStockQuote(order.getStockQuote());
        existing.setPrice(order.getPrice());
        existing.setQuantity(order.getQuantity());
        existing.setDate(order.getDate());

        return service.saveOrder(existing);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
        return "Order deleted successfully";
    }
}