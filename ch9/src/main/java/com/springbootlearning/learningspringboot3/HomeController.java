package com.springbootlearning.learningspringboot3;

import static com.springbootlearning.learningspringboot3.ApiController.DATABASE;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.result.view.Rendering;

@Controller
public class HomeController {
  @GetMapping("/")
  Mono<Rendering> index() {
    return Flux.fromIterable(DATABASE.values()) //
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
      .map(employee -> {
        DATABASE.put(employee.name(), employee);
        return "redirect:/";
      });
  }
}
