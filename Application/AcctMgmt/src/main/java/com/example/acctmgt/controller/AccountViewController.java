package com.example.acctmgt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.acctmgt.entity.AccountTransaction;
import com.example.acctmgt.service.AccountTransactionService;

@Controller
public class AccountViewController {

    private final AccountTransactionService service;

    public AccountViewController(AccountTransactionService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/acct-ui/generate")
    public String generatePage() {
        return "generate-account";
    }

    @PostMapping("/acct-ui/generate")
    public String generateTransaction(@RequestParam Long orderId, Model model) {
        AccountTransaction tx = service.createTransactionFromOrder(orderId);
        model.addAttribute("tx", tx);
        return "account-result";
    }

    @GetMapping("/acct-ui/all")
    public String viewAll(Model model) {
        List<AccountTransaction> transactions = service.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "view-account";
    }
}