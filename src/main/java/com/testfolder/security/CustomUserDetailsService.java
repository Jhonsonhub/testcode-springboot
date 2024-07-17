package com.testfolder.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.testfolder.entity.User;
import com.testfolder.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieve user from the repository based on the username
        User user = userRepository.findByUsername(username);
        
        // Throw exception if user not found
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        // Return UserDetails object (using basic UserDetails implementation from Spring Security)
        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),     // Username
            user.getPassword(),     // Password (typically hashed)
            new ArrayList<>()       // Empty list of authorities (roles)
        );
        
        // Alternatively, if you have a custom UserDetails implementation (CustomUserDetails):
        // return new CustomUserDetails(user);
    }
     
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public void saveUser(User user) {
        userRepository.save(user);
    }
    
    public void deleteUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            userRepository.delete(user);
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    
}
