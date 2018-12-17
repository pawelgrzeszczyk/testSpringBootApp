package com.grzeszczyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.grzeszczyk", "com.grzeszczyk.client.repositories", "com.grzeszczyk.client.services"})
@EnableJpaRepositories(basePackages = "com.grzeszczyk.client.repositories")
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        System.out.println( "Client START!" );
    }

}

