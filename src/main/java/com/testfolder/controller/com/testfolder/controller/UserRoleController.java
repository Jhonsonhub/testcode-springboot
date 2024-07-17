package com.testfolder.controller.com.testfolder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testfolder.entity.User;
import com.testfolder.repository.UserRepository;

@RestController
public class UserRoleController {

    @Autowired
    private UserRepository userRepository;
	
    @GetMapping("/api/userRole")
    public String getUserRole(Model model) {        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userRepository.findByUsername(username);
        String role = user.getRole();

        model.addAttribute("role", role);

        return role;
    }
}
