package com.example.customerproject.controller;

import com.example.customerproject.entity.Customer;
import com.example.customerproject.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer, Model model) {

        String result = customerService.saveCustomer(customer);

        if ("INVALID_ID".equals(result)) {
            model.addAttribute("errorMessage", "Invalid Customer ID! WebUser ID does not exist.");
            model.addAttribute("customer", customer);
            return "customer-form";
        }

        return "redirect:/list";
    }

    @GetMapping("/list")
    public String showAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer-list";
    }
}