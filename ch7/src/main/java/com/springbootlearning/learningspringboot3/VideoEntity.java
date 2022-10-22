package com.springbootlearning.learningspringboot3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class VideoEntity {

  private @Id @GeneratedValue Long id;
  private String username;
  private String name;
  private String description;

  protected VideoEntity() {
    this(null, null, null);
  }

  VideoEntity(String username, String name, String description) {
    this.id = null;
    this.username = username;
    this.description = description;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String user) {
    this.username = user;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "VideoEntity{" + "id=" + id + ", username='" + username + '\'' + ", name='" + name + '\'' + ", description='"
      + description + '\'' + '}';
  }
}
