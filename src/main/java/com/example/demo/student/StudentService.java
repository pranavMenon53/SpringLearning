package com.example.demo.student;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  //   @GetMapping("/getStudents")
  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  /*
  To add new user send POST req to- 
  http://localhost:8080/api/v1/student
  {
    "name": "Arjun",
    "email": "Arjun@gmail.com",
    "dob": "1995-12-17"
  }

  */

  public void addNewStudent(Student student) {
    System.out.println("\n\nIn add Student : " + student);

    Optional<Student> studentByEmail = studentRepository.findStudentByEmail(
      student.getEmail()
    );

    if (studentByEmail.isPresent()) {
      System.out.println("\n\nError! User Already Exists!\n");
      //Throw exception
      throw new IllegalStateException("Can't add a user who exists!");
    }

    studentRepository.save(student);
    System.out.println("\n");
  }

  //********************************

  //This block of code can also be used to delete a student from the DB.
  //It Uses logic similar to the  "addNewStudent" function

  /*
  public void deleteStudent(Student student) {
    System.out.println("\n\nIn delete Student : " + student + "\n\n");
    // Optional<Student>
    Optional<Student> studentByEmail = studentRepository.findStudentByEmail(
      student.getEmail()
    );

    if (studentByEmail.isEmpty()) {
      System.out.println("\n\nError! User does not Exist!\n");
      //Throw exception
      throw new IllegalStateException(
        "Can't delete a user who does not exists!\n"
      );
    }

    studentRepository.deleteStudentByEmail(student.getEmail());
    System.out.println("\n\nStudent Deleted\n\n");
  }
  */
  //********************************

  //This is the code provided in the lecture
  public void deleteStudent(Long studentId) {
    boolean exists = studentRepository.existsById(studentId);

    if (exists) {
      studentRepository.deleteById(studentId);
    } else {
      System.out.println("\n\nUser Does Not Exist!\n\n");
      throw new IllegalStateException(
        "Can't delete a user who deos not exists!"
      );
    }
  }
}
