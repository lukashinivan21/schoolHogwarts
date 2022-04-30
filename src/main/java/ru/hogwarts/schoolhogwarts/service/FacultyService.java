package ru.hogwarts.schoolhogwarts.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.schoolhogwarts.model.Faculty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FacultyService implements FacultyInterface {

    private final Map<Long, Faculty> facultyMap = new HashMap<>();
    private Long numberId = 1L;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(numberId);
        facultyMap.put(numberId, faculty);
        numberId++;
        return faculty;
    }

    public Faculty readFaculty(Long numberId) {
        return facultyMap.get(numberId);
    }

    public Faculty updateFaculty(Faculty faculty) {
        if (!facultyMap.containsKey(faculty.getId())) {
            return null;
        }
        facultyMap.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(Long numberId) {
        return facultyMap.remove(numberId);
    }

    public List<Faculty> facultiesWithThisColor(String color) {
        List<Faculty> faculties = new ArrayList<>();
        for (Faculty faculty : facultyMap.values()){
            if (faculty.getColor().equals(color)) {
                faculties.add(faculty);
            }
        }
        return faculties;
    }
}
