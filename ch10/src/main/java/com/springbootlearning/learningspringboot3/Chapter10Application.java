package com.springbootlearning.learningspringboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
public class Chapter10Application {

  public static void main(String[] args) {
    SpringApplication.run(Chapter10Application.class, args);
  }
}
