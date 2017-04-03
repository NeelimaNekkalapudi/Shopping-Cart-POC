package com.CheckOut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.CheckOut.repository")
public class CheckOutApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckOutApplication.class, args);
	}
}
