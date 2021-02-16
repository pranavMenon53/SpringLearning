package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
    // return List.of(
    // new Student(
    //   1L,
    //   "Purnima",
    //   21,
    //   LocalDate.of(1999, Month.SEPTEMBER, 11),
    //   "gnzsai@amazon.com"
    // ),
    // new Student(
    //   2L,
    //   "Pranav",
    //   21,
    //   LocalDate.of(1999, Month.OCTOBER, 8),
    //   "SM185623@ncr.com"
    // )
    // );
  }

  /*
  
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
      throw new IllegalStateException("Can't add a user who exists!\n");
    }

    studentRepository.save(student);
    System.out.println("\n");
  }

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
}
