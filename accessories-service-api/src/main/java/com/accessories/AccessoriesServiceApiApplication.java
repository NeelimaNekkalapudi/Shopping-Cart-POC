package com.accessories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableMongoRepositories("com.accessories.repository")
public class AccessoriesServiceApiApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(AccessoriesServiceApiApplication.class, args);
    }
}
