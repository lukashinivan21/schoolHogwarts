package ru.hogwarts.schoolhogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.schoolhogwarts.model.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findFacultyByColor(String color);

}
