package ru.hogwarts.schoolhogwarts.service;

import ru.hogwarts.schoolhogwarts.model.Faculty;

public interface FacultyService {

    Faculty createFaculty(Faculty faculty);

    Faculty readFaculty(Long numberId);

    Faculty updateFaculty(Faculty faculty);

    void deleteFaculty(Long numberId);

    Faculty facultyWithThisColor(String color);

    Faculty findFacultyByNameOrColor(String name, String color);
}
