package com.testfolder.controller.com.testfolder.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.testfolder.entity.User;
import com.testfolder.repository.UserRepository;

@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class.getName());

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/login")
	public String loginSubmit(@RequestParam String username,
			@RequestParam String password,
			Model model,
			RedirectAttributes redirectAttributes) {

		boolean isValid = true;
		String usernameErrorMessage = null;
		String passwordErrorMessage = null;

		if (isValid) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if (userDetails != null && userDetails.getPassword().equals(password)) {
				SecurityContextHolder.getContext().setAuthentication(
						new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities()));
				return "redirect:/welcome";
			} else {
				model.addAttribute("loginError", "Invalid username or password");
			}
		}

		model.addAttribute("username", username);
		model.addAttribute("password", password);
		return "login";
	}

	@GetMapping("/")
	public String loginSuccess(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userRepository.findByUsername(username);
		String role = user.getRole();

		model.addAttribute("role", role);
		return "welcome";
	}

	@GetMapping("/manage")
	public String welcome(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userRepository.findByUsername(username); // Adjust this method to match your repository
		String role = user.getRole(); // Adjust this to match how you store roles in your User entity

		// Log the role
		logger.info("Role of the user: " + role);

		model.addAttribute("role", role);
		return "manage";
	}

	// user registration form display
	@GetMapping("/register")
	public String registerUserForm(Model model) {
		model.addAttribute("user", new User()); 
		return "register";
	}

	// user registration form submission
	@PostMapping("/register")
	public String registerUserSubmit(@ModelAttribute User user) {
		
		userRepository.save(user);
		return "redirect:/manage"; 
	}

	// user deletion form display
	@GetMapping("/delete")
	public String deleteUserForm(Model model) {
		// Add logic to fetch users for deletion if needed
		model.addAttribute("users", userRepository.findAll());
		return "delete";
	}

	@PostMapping("/delete")
	public String deleteUserSubmit(@RequestParam String username) {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			userRepository.delete(user);
			return "redirect:/manage"; 
		} else {

			return "error"; // Example: return "error";
		}
	}

}