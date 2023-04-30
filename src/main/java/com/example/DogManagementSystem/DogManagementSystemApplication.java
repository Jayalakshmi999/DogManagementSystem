package com.example.DogManagementSystem;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
/*
 * @author Jaya Lakshmi Medikonda
 */
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DogManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogManagementSystemApplication.class, args);
	}

}
