package com.springbootlearning.learningspringboot3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;

@Configuration
public class SecurityConfig {

  @Bean
  public OAuth2AuthorizedClientManager clientManager( //
    ClientRegistrationRepository clientRegRepo, //
    OAuth2AuthorizedClientRepository authClientRepo) {

    OAuth2AuthorizedClientProvider clientProvider = //
      OAuth2AuthorizedClientProviderBuilder.builder() //
        .authorizationCode() //
        .refreshToken() //
        .clientCredentials() //
        .password() //
        .build();

    DefaultOAuth2AuthorizedClientManager clientManager = //
      new DefaultOAuth2AuthorizedClientManager( //
        clientRegRepo, //
        authClientRepo);
    clientManager //
      .setAuthorizedClientProvider(clientProvider);

    return clientManager;
  }
}
