package com.example.EmployeeManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.EmployeeManagementSystem")
@EnableJpaRepositories(basePackages = {
    "com.example.EmployeeManagementSystem.Repository.Primary",
    "com.example.EmployeeManagementSystem.Repository.Secondary"
})
public class EmployeeManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

}
