package ru.hogwarts.schoolhogwarts.service;

import ru.hogwarts.schoolhogwarts.model.Faculty;
import ru.hogwarts.schoolhogwarts.model.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    Student readStudent(Long numberId);

    Student updateStudent(Student student);

    void deleteStudent(Long numberId);

    List<Student> studentsWithThisAge(int age);

    List<Student> studentsWithAgeBetween(int age1, int age2);

    List<Student> findStudentsByFacultyId(Long numberId);

    List<Student> findStudentsByFacultyColor(String color);

    List<Student> findStudentsByFacultyName(String name);

    Faculty getFacultyOfStudent(Long numberId);
}
