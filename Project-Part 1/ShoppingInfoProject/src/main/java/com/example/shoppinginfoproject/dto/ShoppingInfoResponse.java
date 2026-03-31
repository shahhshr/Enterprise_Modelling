package com.example.shoppinginfoproject.dto;

import com.example.shoppinginfoproject.entity.ShoppingInfo;

import java.util.List;

public class ShoppingInfoResponse {

    private Long loginId;
    private String username;
    private String stateOfUser;
    private List<ShoppingInfo> shoppingItems;

    public ShoppingInfoResponse() {
    }

    public ShoppingInfoResponse(Long loginId, String username, String stateOfUser, List<ShoppingInfo> shoppingItems) {
        this.loginId = loginId;
        this.username = username;
        this.stateOfUser = stateOfUser;
        this.shoppingItems = shoppingItems;
    }

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStateOfUser() {
        return stateOfUser;
    }

    public void setStateOfUser(String stateOfUser) {
        this.stateOfUser = stateOfUser;
    }

    public List<ShoppingInfo> getShoppingItems() {
        return shoppingItems;
    }

    public void setShoppingItems(List<ShoppingInfo> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }
}