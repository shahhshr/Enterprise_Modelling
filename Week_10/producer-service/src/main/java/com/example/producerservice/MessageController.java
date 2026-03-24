package com.example.producerservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @GetMapping("/sendName")
    public String sendName() {
        String name = "Shreya";
        messageProducer.sendMessage("Name: " + name);
        return "Name message sent: " + name;
    }

    @GetMapping("/sendAge")
    public String sendAge() {
        String age = "24";
        messageProducer.sendMessage("Age: " + age);
        return "Age message sent: " + age;
    }
}