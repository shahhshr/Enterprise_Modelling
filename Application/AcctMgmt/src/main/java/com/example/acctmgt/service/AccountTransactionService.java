package com.example.acctmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.acctmgt.dto.OrderDTO;
import com.example.acctmgt.entity.AccountTransaction;
import com.example.acctmgt.repository.AccountTransactionRepository;

@Service
public class AccountTransactionService {

    @Autowired
    private AccountTransactionRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    private final String ORDER_SERVICE_URL = "http://localhost:8081/orders";

   
    public AccountTransaction createTransactionFromOrder(Long orderId) {

        OrderDTO order = restTemplate.getForObject(
                ORDER_SERVICE_URL + "/" + orderId,
                OrderDTO.class
        );

        if (order == null) {
            throw new RuntimeException("Order not found from OrderMgt");
        }

        AccountTransaction tx = new AccountTransaction();
        tx.setOrderId(order.getOrderId());
        tx.setDate(order.getDate());
        tx.setStockQuote(order.getStockQuote());
        tx.setPrice(order.getPrice());
        tx.setQuantity(order.getQuantity());
        tx.setTotalAmount(order.getPrice() * order.getQuantity());
        tx.setTransactionType("ORDER PAYMENT");

        return repo.save(tx);
    }

    
    public List<AccountTransaction> getAllTransactions() {
        return repo.findAll();
    }

   
    public List<AccountTransaction> getTransactionsByOrderId(Long orderId) {
        return repo.findByOrderId(orderId);
    }

    
    public AccountTransaction save(AccountTransaction tx) {
        return repo.save(tx);
    }
}