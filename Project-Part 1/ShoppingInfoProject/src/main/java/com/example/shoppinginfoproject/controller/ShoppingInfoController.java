package com.example.shoppinginfoproject.controller;

import com.example.shoppinginfoproject.dto.ShoppingInfoResponse;
import com.example.shoppinginfoproject.service.ShoppingInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shopping")
public class ShoppingInfoController {

    private final ShoppingInfoService shoppingInfoService;

    public ShoppingInfoController(ShoppingInfoService shoppingInfoService) {
        this.shoppingInfoService = shoppingInfoService;
    }

    // REST API
    @GetMapping("/{loginId}")
    @ResponseBody
    public ResponseEntity<?> getShoppingInfo(@PathVariable Long loginId) {
        ShoppingInfoResponse response = shoppingInfoService.getShoppingInfoByLoginId(loginId);

        if (response == null) {
            return ResponseEntity.badRequest().body("Invalid login id. WebUser not found.");
        }

        return ResponseEntity.ok(response);
    }

    // Thymeleaf page
    @GetMapping("/view/{loginId}")
    public String getShoppingInfoPage(@PathVariable Long loginId, Model model) {
        ShoppingInfoResponse response = shoppingInfoService.getShoppingInfoByLoginId(loginId);

        if (response == null) {
            model.addAttribute("errorMessage", "Invalid login id. WebUser not found.");
            return "shopping-error";
        }

        model.addAttribute("shoppingData", response);
        return "shopping-view";
    }
}