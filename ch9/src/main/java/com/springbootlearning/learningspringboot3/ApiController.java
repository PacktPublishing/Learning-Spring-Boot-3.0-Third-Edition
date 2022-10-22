package com.springbootlearning.learningspringboot3;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
  @GetMapping("/api/employees")
  Flux<Employee> employees() {
    return Flux.just( //
      new Employee("alice", "management"), //
      new Employee("bob", "payroll"));
  }

  public static Map<String, Employee> DATABASE = new LinkedHashMap<>();

  @PostMapping("/api/employees")
  Mono<Employee> add(@RequestBody Mono<Employee> newEmployee) {
    return newEmployee //
      .map(employee -> {
        DATABASE.put(employee.name(), employee);
        return employee;
      });
  }
}
