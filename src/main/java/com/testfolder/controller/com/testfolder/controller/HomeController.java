package com.testfolder.controller.com.testfolder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.testfolder.entity.User;

import jakarta.validation.Valid;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "welcome"; 
    }
    
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    
    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "login";
        }
        
        return "redirect:/";
    }
}