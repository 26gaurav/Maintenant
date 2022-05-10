package com.project.maintenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
        "com.project.maintenant.repo"})
public class MaintenantApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaintenantApplication.class, args);
    }

}
