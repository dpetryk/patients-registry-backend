package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class PatientsRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsRegistryApplication.class, args);
		
	}
}
