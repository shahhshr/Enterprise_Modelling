package com.example.ordermgt.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String date;   
    private String stockQuote;
    private double price;
    private int quantity;

    public Order() {}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDate() {   
        return date;
    }

    public void setDate(String date) {  
        this.date = date;
    }

    public String getStockQuote() {
        return stockQuote;
    }

    public void setStockQuote(String stockQuote) {
        this.stockQuote = stockQuote;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}