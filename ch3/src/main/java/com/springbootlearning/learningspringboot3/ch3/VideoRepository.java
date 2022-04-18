package com.springbootlearning.learningspringboot3.ch3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {

  List<VideoEntity> findByNameContainingIgnoreCase(String partialName);

  List<VideoEntity> findByDescriptionContainingIgnoreCase(String partialDescription);

  List<VideoEntity> findByNameContainingOrDescriptionContainingAllIgnoreCase(String partialName,
    String partialDescription);

}
