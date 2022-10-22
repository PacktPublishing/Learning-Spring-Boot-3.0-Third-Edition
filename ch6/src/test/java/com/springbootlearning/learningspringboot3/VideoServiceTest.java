package com.springbootlearning.learningspringboot3;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;

@ExtendWith(MockitoExtension.class)
public class VideoServiceTest {

  VideoService service;
  @Mock VideoRepository repository;

  @BeforeEach
  void setUp() {
    this.service = new VideoService(repository);
  }

  @Test
  void getVideosShouldReturnAll() {
    // given
    VideoEntity video1 = new VideoEntity("alice", "Spring Boot 3 Intro", "Learn the basics!");
    VideoEntity video2 = new VideoEntity("alice", "Spring Boot 3 Deep Dive", "Go deep!");
    when(repository.findAll()).thenReturn(List.of(video1, video2));

    // when
    List<VideoEntity> videos = service.getVideos();

    // then
    assertThat(videos).containsExactly(video1, video2);
  }

  @Test
  void searchShouldReturnASubset() {
    // given
    VideoEntity video1 = new VideoEntity("alice", "Spring Boot 3 Intro", "Learn the basics!");
    when(repository.findAll(any(Example.class))).thenReturn(List.of(video1));

    // when
    List<VideoEntity> videos = service.search(new Search("Spring Boot 3"));

    // then
    assertThat(videos).containsExactly(video1);
  }

  @Test
  void creatingANewVideoShouldReturnTheSameData() {
    // given
    given(repository.saveAndFlush(any(VideoEntity.class))) //
      .willReturn(new VideoEntity("alice", "name", "des"));

    // when
    VideoEntity newVideo = service.create(new NewVideo("name", "des"), "alice");

    // then
    assertThat(newVideo.getName()).isEqualTo("name");
    assertThat(newVideo.getDescription()).isEqualTo("des");
    assertThat(newVideo.getUsername()).isEqualTo("alice");
  }

  @Test
  void deletingAVideoShouldWork() {
    // given
    VideoEntity entity = new VideoEntity("alice", "name", "desc");
    entity.setId(1L);
    when(repository.findById(1L)).thenReturn(Optional.of(entity));

    // when
    service.delete(1L);

    // then
    verify(repository).findById(1L);
    verify(repository).delete(entity);
  }
}
