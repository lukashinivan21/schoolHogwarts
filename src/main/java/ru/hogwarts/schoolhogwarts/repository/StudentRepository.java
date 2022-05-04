package ru.hogwarts.schoolhogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.schoolhogwarts.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentByAge(int age);

}
