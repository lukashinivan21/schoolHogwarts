package ru.hogwarts.schoolhogwarts.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.schoolhogwarts.model.Faculty;
import ru.hogwarts.schoolhogwarts.repository.FacultyRepository;

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
        return facultyRepository.findById(numberId).orElse(null);
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long numberId) {
        facultyRepository.deleteById(numberId);
    }

    public Faculty facultyWithThisColor(String color) {
        return facultyRepository.findFacultyByColor(color);
    }

    public Faculty findFacultyByNameOrColor(String name, String color) {
        return facultyRepository.findFacultyByNameIgnoreCaseOrColorIgnoreCase(name, color);
    }
}
