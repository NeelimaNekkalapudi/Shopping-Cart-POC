package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringCloudApplication
@EnableMongoRepositories("com.product.repository")
public class ProductServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApiApplication.class, args);
	}
}
