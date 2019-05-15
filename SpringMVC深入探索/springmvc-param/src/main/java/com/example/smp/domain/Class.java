package com.example.smp.domain;

import java.util.List;

public class Class {

  private String className;
  private Teacher teacher;
  private List<Student> students;

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  @Override
  public String toString() {
    return String.format("Class{className='%s', teacher=%s, students=%s}", className, teacher, students);
  }
}
