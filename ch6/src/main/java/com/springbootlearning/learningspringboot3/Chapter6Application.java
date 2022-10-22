package com.springbootlearning.learningspringboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class Chapter6Application {
  public static void main(String[] args) {
    SpringApplication.run(Chapter6Application.class, args);
  }
}
