package com.example.marketmgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.marketmgt.entity.MarketTransaction;
import com.example.marketmgt.service.MarketService;

@RestController
@RequestMapping("/market")
public class MarketController {

    @Autowired
    private MarketService service;

    // Operation 1
    @PostMapping("/place/{orderId}")
    public MarketTransaction placeOrder(@PathVariable Long orderId) {
        return service.placeOrder(orderId);
    }

    // Operation 2
    @GetMapping("/all")
    public List<MarketTransaction> getAllTransactions() {
        return service.getAllTransactions();
    }

    // Operation 3
    @GetMapping("/order/{orderId}")
    public List<MarketTransaction> getByOrder(@PathVariable Long orderId) {
        return service.getByOrderId(orderId);
    }

}