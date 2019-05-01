package com.example.learn.thymeleaf.enums;

public enum Sex {

  /**
   * 男
   */
  MAN(1, "男"),

  /**
   * 女
   */
  WOMAN(2, "女");

  int value;
  String called;

  Sex(int value, String called) {
    this.value = value;
    this.called = called;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getCalled() {
    return called;
  }

  public void setCalled(String called) {
    this.called = called;
  }
}
