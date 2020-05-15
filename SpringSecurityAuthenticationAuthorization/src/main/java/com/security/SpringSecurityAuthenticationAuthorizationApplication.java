package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class SpringSecurityAuthenticationAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAuthenticationAuthorizationApplication.class, args);
	}

}
