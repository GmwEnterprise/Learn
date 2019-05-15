package com.example.smp.domain;

public class Teacher {

  private String teacherName;

  public String getTeacherName() {
    return teacherName;
  }

  public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
  }

  @Override
  public String toString() {
    return String.format("Teacher{teacherName='%s'}", teacherName);
  }
}
