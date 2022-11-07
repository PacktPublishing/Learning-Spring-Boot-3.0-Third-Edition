package com.springbootlearning.learningspringboot3;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class UserAccount {

  @Id
  @GeneratedValue //
  private Long id;
  private String username;
  private String password;
  @ElementCollection(fetch = FetchType.EAGER) //
  private List<GrantedAuthority> authorities = //
    new ArrayList<>();

  protected UserAccount() {}

  public UserAccount(String username, String password, String... authorities) {
    this.username = username;
    this.password = password;
    this.authorities = Arrays.stream(authorities) //
      .map(SimpleGrantedAuthority::new) //
      .map(GrantedAuthority.class::cast) //
      .toList();
  }

  public UserDetails asUser() {
    return User.withDefaultPasswordEncoder() //
      .username(getUsername()) //
      .password(getPassword()) //
      .authorities(getAuthorities()) //
      .build();
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

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<GrantedAuthority> getAuthorities() {
    if (authorities == null) {
      this.authorities = new ArrayList<>();
    }
    return authorities;
  }

  public void setAuthorities(List<GrantedAuthority> authorities) {
    this.authorities = authorities;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserAccount user = (UserAccount) o;
    return Objects.equals(id, user.id) && Objects.equals(username, user.username)
      && Objects.equals(password, user.password) && Objects.equals(authorities, user.authorities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, password, authorities);
  }

  @Override
  public String toString() {
    return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", authorities="
      + authorities + '}';
  }
}
