package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @Autowired
    Environment environment;

    @GetMapping("/")
    public String health() {
        return "right";
    }

    @GetMapping("/backend")
    public String backend() {

        String serverPort = environment.getProperty("local.server.port");
        return "Port: " + serverPort;
    }
}
