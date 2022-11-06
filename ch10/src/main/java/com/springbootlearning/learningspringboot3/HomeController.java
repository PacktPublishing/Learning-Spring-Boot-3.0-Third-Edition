package com.springbootlearning.learningspringboot3;

import reactor.core.publisher.Mono;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.result.view.Rendering;

@Controller
public class HomeController {

  private final EmployeeRepository repository;

  public HomeController(EmployeeRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/")
  Mono<Rendering> index() {
    return repository.findAll() //
      .collectList() //
      .map(employees -> Rendering //
        .view("index") //
        .modelAttribute("employees", employees) //
        .modelAttribute("newEmployee", new Employee("", "")) //
        .build());
  }

  @PostMapping("/new-employee")
  Mono<String> newEmployee(@ModelAttribute Mono<Employee> newEmployee) {
    return newEmployee //
      .flatMap(e -> {
        Employee employeeToSave = new Employee(e.getName(), e.getRole());
        return repository.save(employeeToSave);
      }) //
      .map(employee -> "redirect:/");
  }
}
