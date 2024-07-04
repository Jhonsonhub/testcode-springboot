package com.testfolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@ComponentScan(basePackages = "com.testfolder") // Scan all packages including com.testfolder.config
@EntityScan("com.testfolder.entity") // Scan package where your entities reside
public class WelcomePageApplication {
	@GetMapping("/")
    public static void main(String[] args) {
        SpringApplication.run(WelcomePageApplication.class, args);
    }
}
