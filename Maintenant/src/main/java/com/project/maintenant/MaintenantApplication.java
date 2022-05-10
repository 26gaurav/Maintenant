package com.project.maintenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.project.maintenant.repo")
public class MaintenantApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaintenantApplication.class, args);
    }

}


//@EnableTransactionManagement
//@EntityScan(basePackages="com.project.maintenant.model")
