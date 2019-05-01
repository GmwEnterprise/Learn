package com.example.learn.thymeleaf.domain;

import com.example.learn.thymeleaf.enums.Sex;

public class User {

  private Long id;
  private String name;
  private Sex sex;

  public User() {
  }

  public User(Long id, String name, Sex sex) {
    this.id = id;
    this.name = name;
    this.sex = sex;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }
}
