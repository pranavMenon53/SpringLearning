package com.example.demo.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/getStudents")
  public List<Student> getStudents() {
    return studentService.getStudents();
  }

  @PostMapping
  public void registerNewStudent(@RequestBody Student student) {
    studentService.addNewStudent(student);
  }

  //Use this endpoint to delete a student using the commented out code block in StudentService.java
  // @DeleteMapping
  // public void deleteStudent(@RequestBody Student student) {
  //   studentService.deleteStudent(student);
  // }

  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable("studentId") Long studentId) {
    studentService.deleteStudent(studentId);
  }

  //Update users
  @PutMapping(path = "{studentId}")
  public void updateStudent(
    @PathVariable("studentId") Long studentId,
    @RequestParam(required = false) String name,
    @RequestParam(required = false) String email
  ) {
    studentService.updateStudent(studentId, name, email);
  }
}
