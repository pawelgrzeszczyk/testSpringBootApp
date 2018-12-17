package com.grzeszczyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.grzeszczyk", "com.grzeszczyk.repositories", "com.grzeszczyk.services"})
@EnableJpaRepositories(basePackages = "com.grzeszczyk.repositories")
public class CarCatalogApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(CarCatalogApp.class, args);
        System.out.println( "CarCatalog START!" );
    }
}
