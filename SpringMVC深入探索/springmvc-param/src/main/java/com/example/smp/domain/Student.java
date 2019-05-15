package com.example.smp.domain;

public class Student {

  private String studentName;

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  @Override
  public String toString() {
    return String.format("Student{studentName='%s'}", studentName);
  }
}
