package ru.hogwarts.schoolhogwarts.service;

import ru.hogwarts.schoolhogwarts.model.Student;

import java.util.List;

public interface StudentInterface {

    Student createStudent(Student student);

    Student readStudent(Long numberId);

    Student updateStudent(Student student);

    Student deleteStudent(Long numberId);

    List<Student> studentsWithThisAge(int age);
}
