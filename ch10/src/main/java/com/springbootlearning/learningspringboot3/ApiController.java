package com.springbootlearning.learningspringboot3;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

  private final EmployeeRepository repository;

  public ApiController(EmployeeRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/api/employees")
  Flux<Employee> employees() {
    return repository.findAll();
  }

  @PostMapping("/api/employees")
  Mono<Employee> add(@RequestBody Mono<Employee> newEmployee) {
    return newEmployee.flatMap(e -> {
      Employee employeeToLoad = new Employee(e.getName(), e.getRole());
      return repository.save(employeeToLoad);
    });
  }
}
