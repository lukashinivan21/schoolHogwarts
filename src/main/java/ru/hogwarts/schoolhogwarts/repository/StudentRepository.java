package ru.hogwarts.schoolhogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.schoolhogwarts.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentsByAge(int age);

    List<Student> findStudentsByAgeBetween(int age1, int age2);

    List<Student> findStudentsByFaculty_Id(Long numberId);

    List<Student> findStudentsByFaculty_ColorIgnoreCase(String color);

    List<Student> findStudentsByFaculty_NameIgnoreCase(String name);

}
