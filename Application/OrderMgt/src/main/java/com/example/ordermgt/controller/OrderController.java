package com.example.ordermgt.controller;

import com.example.ordermgt.entity.Order;
import com.example.ordermgt.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    private final OrderRepository repo;

    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    // HOME PAGE
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // VIEW ALL
    @GetMapping("/orders")
    public String viewOrders(Model model) {
        model.addAttribute("orders", repo.findAll());
        return "view-orders";
    }

    // ADD PAGE
    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("order", new Order());
        return "add-order";
    }

    // SAVE
    @PostMapping("/save")
    public String save(@ModelAttribute Order order) {
        repo.save(order);
        return "redirect:/orders";
    }

    // UPDATE PAGE
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Order order = repo.findById(id).orElse(null);
        model.addAttribute("order", order);
        return "update-order";
    }

    // UPDATE SAVE
    @PostMapping("/update")
    public String update(@ModelAttribute Order order) {
        repo.save(order);
        return "redirect:/orders";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/orders";
    }
}