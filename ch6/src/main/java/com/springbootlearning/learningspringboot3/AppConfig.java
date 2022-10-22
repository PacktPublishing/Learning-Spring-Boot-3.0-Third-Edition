package com.springbootlearning.learningspringboot3;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app.config")
public record AppConfig(String header, String intro, List<UserAccount> users) {
}
