package ru.hogwarts.schoolhogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.schoolhogwarts.model.Faculty;


public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Faculty findFacultyByColor(String color);

    Faculty findFacultyByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
}
