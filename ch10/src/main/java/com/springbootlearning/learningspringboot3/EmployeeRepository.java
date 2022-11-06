package com.springbootlearning.learningspringboot3;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends //
  ReactiveCrudRepository<Employee, Long> {}
