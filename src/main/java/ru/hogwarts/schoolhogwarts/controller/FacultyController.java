package ru.hogwarts.schoolhogwarts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.schoolhogwarts.model.Faculty;
import ru.hogwarts.schoolhogwarts.service.FacultyInterface;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyInterface facultyInterface;

    public FacultyController(FacultyInterface facultyInterface) {
        this.facultyInterface = facultyInterface;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyInterface.createFaculty(faculty);
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable Long id) {
        Faculty gettingFaculty = facultyInterface.readFaculty(id);
        if (gettingFaculty == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(gettingFaculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatingFaculty = facultyInterface.updateFaculty(faculty);
        if (updatingFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updatingFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty>  deleteFaculty(@PathVariable Long id) {
        Faculty deletingFaculty = facultyInterface.deleteFaculty(id);
        if (deletingFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletingFaculty);
    }

    @GetMapping("/facultyWithColor{color}")
    public ResponseEntity<List<Faculty>> getAllFacultiesWithThisColor(@PathVariable String color) {
        List<Faculty> facultiesWithThisColor = facultyInterface.facultiesWithThisColor(color);
        if (facultiesWithThisColor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(facultiesWithThisColor);
    }
}
