package ru.hogwarts.schoolhogwarts.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.schoolhogwarts.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final Map<Long, Student> studentsMap = new HashMap<>();
    private Long numberId = 1L;

    public Student createStudent(Student student) {
        student.setId(numberId);
        studentsMap.put(numberId, student);
        numberId++;
        return student;
    }

    public Student readStudent(Long numberId) {
        return studentsMap.get(numberId);
    }

    public Student updateStudent(Student student) {
        if (!studentsMap.containsKey(student.getId())) {
            return null;
        }
        studentsMap.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(Long numberId) {
        return studentsMap.remove(numberId);
    }

    public List<Student> studentsWithThisAge(int age) {
        return studentsMap.values().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toUnmodifiableList());
    }
}
