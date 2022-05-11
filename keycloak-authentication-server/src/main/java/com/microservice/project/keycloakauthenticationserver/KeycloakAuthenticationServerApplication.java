package com.microservice.project.keycloakauthenticationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = ReactiveUserDetailsServiceAutoConfiguration.class)
public class KeycloakAuthenticationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakAuthenticationServerApplication.class, args);
	}

}
