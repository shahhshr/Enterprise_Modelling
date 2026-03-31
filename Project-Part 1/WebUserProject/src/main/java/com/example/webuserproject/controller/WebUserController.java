package com.example.webuserproject.controller;

import com.example.webuserproject.entity.WebUser;
import com.example.webuserproject.service.WebUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebUserController {

    private final WebUserService webUserService;

    public WebUserController(WebUserService webUserService) {
        this.webUserService = webUserService;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("webUser", new WebUser());
        return "webuser-form";
    }

    @PostMapping("/saveWebUser")
    public String saveWebUser(@ModelAttribute WebUser webUser) {
        webUserService.saveWebUser(webUser);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String showAllUsers(Model model) {
        model.addAttribute("users", webUserService.getAllWebUsers());
        return "webuser-list";
    }
}