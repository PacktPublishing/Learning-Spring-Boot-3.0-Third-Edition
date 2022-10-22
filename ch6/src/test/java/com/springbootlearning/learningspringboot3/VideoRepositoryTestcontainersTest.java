package com.springbootlearning.learningspringboot3;

import static com.springbootlearning.learningspringboot3.VideoRepositoryTestcontainersTest.*;
import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ContextConfiguration(initializers = DataSourceInitializer.class)
public class VideoRepositoryTestcontainersTest {

  @Autowired VideoRepository repository;

  @Container //
  static final PostgreSQLContainer<?> database = //
    new PostgreSQLContainer<>("postgres:9.6.12") //
      .withUsername("postgres");

  static class DataSourceInitializer //
    implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
      TestPropertySourceUtils.addInlinedPropertiesToEnvironment(applicationContext, //
        "spring.datasource.url=" + database.getJdbcUrl(), //
        "spring.datasource.username=" + database.getUsername(), //
        "spring.datasource.password=" + database.getPassword(), //
        "spring.jpa.hibernate.ddl-auto=create-drop");
    }
  }

  @BeforeEach
  void setUp() {
    repository.saveAll( //
      List.of( //
        new VideoEntity( //
          "alice", //
          "Need HELP with your SPRING BOOT 3 App?", //
          "SPRING BOOT 3 will only speed things up."),
        new VideoEntity("alice", //
          "Don't do THIS to your own CODE!", //
          "As a pro developer, never ever EVER do this to your code."),
        new VideoEntity("bob", //
          "SECRETS to fix BROKEN CODE!", //
          "Discover ways to not only debug your code")));
  }

  @Test
  void findAllShouldProduceAllVideos() {
    List<VideoEntity> videos = repository.findAll();
    assertThat(videos).hasSize(3);
  }

  @Test
  void findByName() {
    List<VideoEntity> videos = repository.findByNameContainsIgnoreCase("SPRING BOOT 3");
    assertThat(videos).hasSize(1);
  }

  @Test
  void findByNameOrDescription() {
    List<VideoEntity> videos = repository.findByNameContainsOrDescriptionContainsAllIgnoreCase("CODE", "your code");
    assertThat(videos).hasSize(2);
  }
}
