package com.m2g2.singular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SingularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingularApplication.class, args);		
	}

}
