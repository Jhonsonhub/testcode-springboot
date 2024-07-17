package com.testfolder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.testfolder.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

	@Autowired
	private CustomUserDetailsService userDetailsService;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@SuppressWarnings("deprecation")
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.requestMatchers("/", "/login",  "/manage", "/register", "/delete", "/js/**", "/css/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/perform_login")
				.defaultSuccessUrl("/success", true)
				.failureUrl("/login?error=true")
				.and()
				.logout()
				.logoutUrl("/perform_logout")
				.deleteCookies("JSESSIONID")
				;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString(); // No encoding
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return rawPassword.toString().equals(encodedPassword); // No encoding
			}
		};
	}
}