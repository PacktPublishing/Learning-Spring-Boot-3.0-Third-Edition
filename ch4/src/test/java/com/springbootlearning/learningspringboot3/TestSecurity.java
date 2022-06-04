package com.springbootlearning.learningspringboot3;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

public class TestSecurity {

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetailsManager userDetailsManager = //
      new InMemoryUserDetailsManager();
    userDetailsManager.createUser( //
      User.withDefaultPasswordEncoder() //
        .username("user") //
        .password("password") //
        .roles("USER") //
        .build());
    userDetailsManager.createUser( //
      User.withDefaultPasswordEncoder() //
        .username("admin") //
        .password("password") //
        .roles("ADMIN") //
        .build());
    return userDetailsManager;
  }

}
