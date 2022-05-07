package ru.hogwarts.schoolhogwarts.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.schoolhogwarts.model.Faculty;
import ru.hogwarts.schoolhogwarts.model.Student;
import ru.hogwarts.schoolhogwarts.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student readStudent(Long numberId) {
        return studentRepository.findById(numberId).orElse(null);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long numberId) {
        studentRepository.deleteById(numberId);
    }

    public List<Student> studentsWithThisAge(int age) {
        List<Student> students = studentRepository.findStudentsByAge(age);
        if (students.isEmpty()) {
            return null;
        }
        return students;
    }

    public List<Student> studentsWithAgeBetween(int age1, int age2) {
        List<Student> students = studentRepository.findStudentsByAgeBetween(age1, age2);
        if (students.isEmpty()) {
            return null;
        }
        return students;
    }

    public List<Student> findStudentsByFacultyId(Long numberId) {
        List<Student> result = studentRepository.findStudentsByFaculty_Id(numberId);
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    public List<Student> findStudentsByFacultyColor(String color) {
        List<Student> result = studentRepository.findStudentsByFaculty_ColorIgnoreCase(color);
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    public List<Student> findStudentsByFacultyName(String name) {
        List<Student> result = studentRepository.findStudentsByFaculty_NameIgnoreCase(name);
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    @Override
    public Faculty getFacultyOfStudent(Long numberId) {
        Student student = studentRepository.findById(numberId).orElse(null);
        if (student == null) {
            return null;
        }
        return student.getFaculty();
    }
}
