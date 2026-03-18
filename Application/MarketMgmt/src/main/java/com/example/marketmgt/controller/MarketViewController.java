package com.example.marketmgt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.marketmgt.entity.MarketTransaction;
import com.example.marketmgt.service.MarketService;

@Controller
public class MarketViewController {

    private final MarketService marketService;

    public MarketViewController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/market-ui/place")
    public String placePage() {
        return "place-market";
    }

    @PostMapping("/market-ui/place")
    public String placeOrder(@RequestParam Long orderId, Model model) {
        MarketTransaction tx = marketService.placeOrder(orderId);
        model.addAttribute("tx", tx);
        return "market-result";
    }

    @GetMapping("/market-ui/all")
    public String viewAll(Model model) {
        List<MarketTransaction> transactions = marketService.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "view-market";
    }
}