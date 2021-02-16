package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Student {

  @Id
  //Block 1
  @SequenceGenerator(
    name = "student_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "student_sequence"
  )
  //Block 1 Ends

  //Block 1 is used to create a sequence
  // Removing block 1 will create only a table
  private Long id;

  private String name;
  private LocalDate dob;
  private String email;

  @Transient
  private Integer age;

  public Student() {}

  public Student(Long id, String name, LocalDate dob, String email) {
    this.id = id;
    this.name = name;

    this.dob = dob;
    this.email = email;
  }

  public Student(String name, LocalDate dob, String email) {
    this.name = name;

    this.dob = dob;
    this.email = email;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return Period.between(this.dob, LocalDate.now()).getYears();
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public LocalDate getDob() {
    return this.dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return (
      "{" +
      " id='" +
      getId() +
      "'" +
      ", name='" +
      getName() +
      "'" +
      ", age='" +
      getAge() +
      "'" +
      ", dob='" +
      getDob() +
      "'" +
      ", email='" +
      getEmail() +
      "'" +
      "}"
    );
  }
}
