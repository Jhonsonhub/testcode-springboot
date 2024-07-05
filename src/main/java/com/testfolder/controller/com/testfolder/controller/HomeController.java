package com.testfolder.controller.com.testfolder.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "welcome"; // welcome.jsp
    }
    
    @GetMapping("/login")
    public String login() {
        return "login"; //  login.html 
    }
    
    @GetMapping("/success")
    public String loginSuccess() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        return "success"; // success.html
    }
}