package ru.hogwarts.schoolhogwarts.service;

import org.springframework.stereotype.Service;
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
        return studentRepository.getById(numberId);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long numberId) {
        studentRepository.deleteById(numberId);
    }

    public List<Student> studentsWithThisAge(int age) {
        return studentRepository.findStudentByAge(age);
    }
}
