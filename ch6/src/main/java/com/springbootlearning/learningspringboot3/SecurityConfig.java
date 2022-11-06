package com.springbootlearning.learningspringboot3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

  interface GrantedAuthorityCnv extends Converter<String, GrantedAuthority> {}

  @Bean
  @ConfigurationPropertiesBinding
  GrantedAuthorityCnv converter() {
    return SimpleGrantedAuthority::new;
  }

  @Bean
  CommandLineRunner initUsers(UserManagementRepository repository, AppConfig appConfig) {
    return args -> repository.saveAll(appConfig.users());
  }

  @Bean
  UserDetailsService userService(UserRepository repo) {
    return username -> repo.findByUsername(username).asUser();
  }

  @Bean
  SecurityFilterChain configureSecurity(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests() //
      .requestMatchers("/login").permitAll() //
      .requestMatchers("/", "/search").authenticated() //
      .requestMatchers(HttpMethod.GET, "/api/**").authenticated() //
      .requestMatchers(HttpMethod.POST, "/delete/**", "/new-video").authenticated() //
      .anyRequest().denyAll() //
      .and() //
      .formLogin() //
      .and() //
      .httpBasic();
    return http.build();
  }
}
