package com.testfolder.controller.com.testfolder.controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
public class WelcomePageApplication {
	@GetMapping("/")
    public static void main(String[] args) {
        SpringApplication.run(WelcomePageApplication.class, args);
    }
}
