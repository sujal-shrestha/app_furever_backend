package com.example.app_furever_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.app_furever_backend")
@EnableJpaRepositories(basePackages = "com.example.app_furever_backend.repo")
public class AppFureverBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppFureverBackendApplication.class, args);
    }
}
