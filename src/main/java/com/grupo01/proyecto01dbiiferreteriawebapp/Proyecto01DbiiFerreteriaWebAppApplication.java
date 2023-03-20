package com.grupo01.proyecto01dbiiferreteriawebapp;

import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.CustomerEntity;
import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Proyecto01DbiiFerreteriaWebAppApplication {

    private static final Logger log = LoggerFactory.getLogger(Proyecto01DbiiFerreteriaWebAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Proyecto01DbiiFerreteriaWebAppApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /*@Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            //save a few customers
            repository.save(new CustomerEntity(103450876, "Alex", "Peralta",
                    23459876, "Some address", "example1@example.com"));
            repository.save(new CustomerEntity(309870456, "María", "Gonzales",
                    89764321, "Some address", "example2@example.com"));
            repository.save(new CustomerEntity(207640987, "Veronica", "Pérez",
                    65438911, "Some address", "example3@example.com"));

            //fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (CustomerEntity customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            //fetch an individual customer by ID
            CustomerEntity customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            //fetch customer by last name
            log.info("Customer found with findByLastName('Gonzales'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Gonzales").forEach(gonzales -> {
                log.info(gonzales.toString());
            });
            log.info("");

        };
    }*/

}
