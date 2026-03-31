package com.example.shoppinginfoproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "web_user")
public class WebUser {

    @Id
    private Long id;

    private String username;
    private String password;

    @Column(name = "state_of_user")
    private String stateOfUser;

    public WebUser() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStateOfUser() {
        return stateOfUser;
    }
}