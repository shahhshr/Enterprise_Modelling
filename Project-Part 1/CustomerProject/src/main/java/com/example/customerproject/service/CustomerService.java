package com.example.customerproject.service;

import com.example.customerproject.entity.Customer;
import com.example.customerproject.repository.CustomerRepository;
import com.example.customerproject.repository.WebUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final WebUserRepository webUserRepository;

    public CustomerService(CustomerRepository customerRepository,
                           WebUserRepository webUserRepository) {
        this.customerRepository = customerRepository;
        this.webUserRepository = webUserRepository;
    }

    public String saveCustomer(Customer customer) {

        boolean exists = webUserRepository.existsById(customer.getCustomerId());

        if (!exists) {
            return "INVALID_ID";
        }

        customerRepository.save(customer);
        return "SUCCESS";
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}