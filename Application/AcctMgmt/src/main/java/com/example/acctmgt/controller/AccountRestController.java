package com.example.acctmgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.acctmgt.entity.AccountTransaction;
import com.example.acctmgt.service.AccountTransactionService;

@RestController
@RequestMapping("/acct")
public class AccountRestController {

    @Autowired
    private AccountTransactionService service;

    @PostMapping("/generate/{orderId}")
    public AccountTransaction generateTransaction(@PathVariable Long orderId) {
        return service.createTransactionFromOrder(orderId);
    }

    @GetMapping("/all")
    public List<AccountTransaction> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/order/{orderId}")
    public List<AccountTransaction> getTransactionsByOrder(@PathVariable Long orderId) {
        return service.getTransactionsByOrderId(orderId);
    }

    @PostMapping("/save")
    public AccountTransaction save(@RequestBody AccountTransaction tx) {
        return service.save(tx);
    }
}