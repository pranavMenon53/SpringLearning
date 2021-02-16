package com.example.demo.student;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  //The "Student" referenced below is the Student.java class.
  @Query("Select s from Student s where s.email = ?1")
  Optional<Student> findStudentByEmail(String email);

  //Questions -
  /* 
    1) What is Optional<Student>?
    2) In Query, What is '?1' ?
  */
  @Transactional
  @Modifying
  @Query("delete from Student s where s.email = ?1")
  void deleteStudentByEmail(String email);
}
