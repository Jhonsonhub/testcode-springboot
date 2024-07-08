package com.testfolder.controller.com.testfolder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.testfolder.entity.User;
import com.testfolder.repository.UserRepository;

@Controller
public class HomeController {
	
    @Autowired
    private UserRepository userRepository;
	
    @GetMapping("/")
    public String home() {
        return "welcome"; // welcome.jsp
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
       
        return "redirect:/success";
    }
    
    @GetMapping("/success")
    public String loginSuccess() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        return "success"; // success.html
    }
}