package com.testfolder.controller.com.testfolder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "welcome"; // This will return a view named "welcome.jsp"
    }
    
    @GetMapping("/success")
    public String success() {
        return "success"; // Return the success view (success.html)
    }
}