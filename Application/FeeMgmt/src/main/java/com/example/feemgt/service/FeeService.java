package com.example.feemgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.feemgt.dto.OrderDTO;
import com.example.feemgt.entity.Fee;
import com.example.feemgt.repository.FeeRepository;

@Service
public class FeeService {

    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private RestTemplate restTemplate;

    // change this if your OrderMgt runs on another port
    private final String ORDER_SERVICE_URL = "http://localhost:8081/orders";

    // Operation 1:
    // Consume Order data from OrderMgt and store fee log
    public Fee generateFeeFromOrder(Long orderId) {
        OrderDTO order = restTemplate.getForObject(
                ORDER_SERVICE_URL + "/" + orderId,
                OrderDTO.class
        );

        if (order == null) {
            throw new RuntimeException("Order not found from OrderMgt service");
        }

        double orderAmount = order.getPrice() * order.getQuantity();

        // Business rule example: 5% fee
        double feeAmount = orderAmount * 0.05;

        Fee fee = new Fee();
        fee.setDate(order.getDate());
        fee.setOrderId(order.getOrderId());
        fee.setOrderAmount(orderAmount);
        fee.setFeeAmount(feeAmount);
        fee.setFeeType("5% TRANSACTION FEE");

        return feeRepository.save(fee);
    }

    // Operation 2:
    public List<Fee> getAllFees() {
        return feeRepository.findAll();
    }

    // Operation 3:
    public List<Fee> getFeesByOrderId(Long orderId) {
        return feeRepository.findByOrderId(orderId);
    }

    // Operation 4:
    public Fee saveFee(Fee fee) {
        return feeRepository.save(fee);
    }
}