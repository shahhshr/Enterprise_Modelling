package com.example.shoppinginfoproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shopping_info")
public class ShoppingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_id")
    private Long shoppingId;

    @Column(name = "login_id")
    private Long loginId;

    @Column(name = "product_name")
    private String productName;

    private Integer quantity;
    private Double price;

    public ShoppingInfo() {
    }

    public ShoppingInfo(Long shoppingId, Long loginId, String productName, Integer quantity, Double price) {
        this.shoppingId = shoppingId;
        this.loginId = loginId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(Long shoppingId) {
        this.shoppingId = shoppingId;
    }

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}