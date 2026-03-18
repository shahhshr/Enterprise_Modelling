package com.example.marketmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.marketmgt.dto.OrderDTO;
import com.example.marketmgt.entity.MarketTransaction;
import com.example.marketmgt.repository.MarketRepository;

@Service
public class MarketService {

    @Autowired
    private MarketRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    private final String ORDER_SERVICE_URL = "http://localhost:8081/orders";

    // Operation 1
    public MarketTransaction placeOrder(Long orderId) {

        OrderDTO order = restTemplate.getForObject(
                ORDER_SERVICE_URL + "/" + orderId,
                OrderDTO.class
        );

        if (order == null) {
            throw new RuntimeException("Order not found");
        }

        MarketTransaction tx = new MarketTransaction();

        tx.setOrderId(order.getOrderId());
        tx.setStockQuote(order.getStockQuote());
        tx.setQuantity(order.getQuantity());
        tx.setPrice(order.getPrice());
        tx.setDate(order.getDate());

        // simulate market placement
        tx.setStatus("PLACED TO STOCK EXCHANGE");

        return repo.save(tx);
    }

    // Operation 2
    public List<MarketTransaction> getAllTransactions() {
        return repo.findAll();
    }

    // Operation 3
    public List<MarketTransaction> getByOrderId(Long orderId) {
        return repo.findByOrderId(orderId);
    }

}