package com.example.feemgt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.feemgt.entity.Fee;
import com.example.feemgt.service.FeeService;

@Controller
public class FeeViewController {

    private final FeeService feeService;

    public FeeViewController(FeeService feeService) {
        this.feeService = feeService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/fees-ui/generate")
    public String generatePage() {
        return "generate-fee";
    }

    @PostMapping("/fees-ui/generate")
    public String generateFee(@RequestParam Long orderId, Model model) {
        Fee fee = feeService.generateFeeFromOrder(orderId);
        model.addAttribute("fee", fee);
        return "fee-result";
    }

    @GetMapping("/fees-ui/all")
    public String viewAllFees(Model model) {
        List<Fee> fees = feeService.getAllFees();
        model.addAttribute("fees", fees);
        return "view-fees";
    }
}