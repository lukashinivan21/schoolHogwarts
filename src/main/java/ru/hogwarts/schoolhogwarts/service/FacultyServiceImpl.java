package ru.hogwarts.schoolhogwarts.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.schoolhogwarts.model.Faculty;
import ru.hogwarts.schoolhogwarts.repository.FacultyRepository;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty readFaculty(Long numberId) {
        return facultyRepository.getById(numberId);
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long numberId) {
        facultyRepository.deleteById(numberId);
    }

    public List<Faculty> facultiesWithThisColor(String color) {
        return facultyRepository.findFacultyByColor(color);
    }
}
