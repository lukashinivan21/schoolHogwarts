package ru.hogwarts.schoolhogwarts.service;

import ru.hogwarts.schoolhogwarts.model.Faculty;

import java.util.List;

public interface FacultyService {

    Faculty createFaculty(Faculty faculty);

    Faculty readFaculty(Long numberId);

    Faculty updateFaculty(Faculty faculty);

    void deleteFaculty(Long numberId);

    List<Faculty> facultiesWithThisColor(String color);
}
