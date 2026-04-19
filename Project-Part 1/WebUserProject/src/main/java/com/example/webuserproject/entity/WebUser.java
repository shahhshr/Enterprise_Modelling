package com.example.webuserproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "web_user")
public class WebUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Column(name = "state_of_user")
    private String stateOfUser;

    public WebUser() {
    }

    public WebUser(Long id, String username, String password, String stateOfUser) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.stateOfUser = stateOfUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStateOfUser() {
        return stateOfUser;
    }

    public void setStateOfUser(String stateOfUser) {
        this.stateOfUser = stateOfUser;
    }
}