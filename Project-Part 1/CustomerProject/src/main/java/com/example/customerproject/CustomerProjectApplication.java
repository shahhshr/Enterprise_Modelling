package com.example.customerproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.customerproject.repository")
@EntityScan(basePackages = "com.example.customerproject.entity")
public class CustomerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerProjectApplication.class, args);
	}
}