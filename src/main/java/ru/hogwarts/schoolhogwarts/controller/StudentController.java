package ru.hogwarts.schoolhogwarts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.schoolhogwarts.model.Student;
import ru.hogwarts.schoolhogwarts.service.StudentInterface;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentInterface studentInterface;

    public StudentController(StudentInterface studentInterface) {
        this.studentInterface = studentInterface;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentInterface.createStudent(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        Student gettingStudent = studentInterface.readStudent(id);
        if (gettingStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gettingStudent);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatingStudent = studentInterface.updateStudent(student);
        if (updatingStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updatingStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Student deletingStudent = studentInterface.deleteStudent(id);
        if (deletingStudent == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(deletingStudent);
    }

    @GetMapping("/studentWithAge{age}")
    public ResponseEntity<List<Student>> getStudentsWithThisAge(@PathVariable int age) {
        List<Student> studentsWithThisAge = studentInterface.studentsWithThisAge(age);
        if (studentsWithThisAge == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentInterface.studentsWithThisAge(age));
    }
}
