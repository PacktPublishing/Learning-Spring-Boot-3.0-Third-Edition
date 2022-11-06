package com.springbootlearning.learningspringboot3;

import org.springframework.context.annotation.Configuration;
import reactor.test.StepVerifier;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;

@Configuration
public class Startup {
  @Bean
  CommandLineRunner initDatabase(R2dbcEntityTemplate template) {
    return args -> {
      template.getDatabaseClient() //
        .sql("CREATE TABLE EMPLOYEE (id IDENTITY NOT NULL PRIMARY KEY , name VARCHAR(255), role VARCHAR(255))") //
        .fetch() //
        .rowsUpdated() //
        .as(StepVerifier::create) //
        .expectNextCount(1) //
        .verifyComplete();

      template.insert(Employee.class) //
        .using(new Employee("Frodo Baggins", "ring bearer")) //
        .as(StepVerifier::create) //
        .expectNextCount(1) //
        .verifyComplete();

      template.insert(Employee.class) //
        .using(new Employee("Samwise Gamgee", "gardener")) //
        .as(StepVerifier::create) //
        .expectNextCount(1) //
        .verifyComplete();

      template.insert(Employee.class) //
        .using(new Employee("Bilbo Baggins", "burglar")) //
        .as(StepVerifier::create) //
        .expectNextCount(1) //
        .verifyComplete();
    };
  }
}
