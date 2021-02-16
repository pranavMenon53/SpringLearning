package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

  int i = 0;
  Student[] students = new Student[] {
    new Student(
      1L,
      "Purnima",
      LocalDate.of(1981, Month.SEPTEMBER, 11),
      "gnzsai@amazon.com"
    ),
    new Student(
      2L,
      "Pranav",
      LocalDate.of(1929, Month.OCTOBER, 8),
      "SM185623@ncr.com"
    ),
    new Student(
      3L,
      "Pinky",
      LocalDate.of(1993, Month.SEPTEMBER, 11),
      "pinky@amazon.com"
    ),
    new Student(
      4L,
      "Acchu",
      LocalDate.of(1999, Month.OCTOBER, 8),
      "Acchu@ncr.com"
    ),
  };

  @Bean
  CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
    return args -> {
      // Student stu1 = new Student(
      //   1L,
      //   "Purnima",
      //   21,
      //   LocalDate.of(1999, Month.SEPTEMBER, 11),
      //   "gnzsai@amazon.com"
      // );
      // Student stu2 = new Student(
      //   2L,
      //   "Pranav",
      //   22,
      //   LocalDate.of(1999, Month.OCTOBER, 8),
      //   "SM185623@ncr.com"
      // );

      // studentRepository.saveAll(List.of(stu1, stu2));

      /* 
        Notes - 
        1) The above commented code is one way to add new elements to the DB
        2) The method below iterates over the Student objects and adds them one after the other
        3) Un-Comment the timeUnit statement to induce a delay and see the difference
      */

      while (i < 4) {
        studentRepository.save(students[i++]);
        // System.out.println("\n\nSleeping now! i : " + i + "\n\n");
        // TimeUnit.SECONDS.sleep(5);
      }
    };
  }
}
