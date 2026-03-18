package com.example.feemgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.feemgt.entity.Fee;
import com.example.feemgt.service.FeeService;

@RestController
@RequestMapping("/fees")
public class FeeController {

    @Autowired
    private FeeService feeService;

    // 1. Consume order data from OrderMgt and create fee record
    @PostMapping("/generate/{orderId}")
    public Fee generateFee(@PathVariable Long orderId) {
        return feeService.generateFeeFromOrder(orderId);
    }

    // 2. Show all fee records
    @GetMapping("/all")
    public List<Fee> getAllFees() {
        return feeService.getAllFees();
    }

    // 3. Show fee by orderId
    @GetMapping("/order/{orderId}")
    public List<Fee> getFeesByOrderId(@PathVariable Long orderId) {
        return feeService.getFeesByOrderId(orderId);
    }

    // 4. Manual insert if needed
    @PostMapping("/save")
    public Fee saveFee(@RequestBody Fee fee) {
        return feeService.saveFee(fee);
    }
}