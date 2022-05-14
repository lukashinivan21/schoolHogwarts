package ru.hogwarts.schoolhogwarts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.hogwarts.schoolhogwarts.controller.StudentController;
import ru.hogwarts.schoolhogwarts.model.Student;

import java.util.Objects;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads() {
        Assertions.assertThat(studentController).isNotNull();
    }

    @Test
    public void getStudentInfoTest() {
        long id = 14L;
        Assertions
                .assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/student" + id, String.class))
                .isNotEmpty();
    }

    @Test
    public void getStudentsWithThisAgeTest() {
        int age = 28;
        Assertions.
                assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/student/studentsWithAge/" + age, String.class))
                .isNotEmpty();
    }

    @Test
    public void getStudentsWithAgeBetweenTest() {
        int age1 = 28;
        int age2 = 30;
        Assertions
                .assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/student/studentsWithAgeBetween?age1="
                        + age1 + "&age2=" + age2, String.class))
                .isNotEmpty();
    }

    @Test
    public void allStudentsAtFacultyTest() {
        String color = "Green";
        Assertions
                .assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/student/studentsAtFaculty?color="
                        + color, String.class))
                .isNotEmpty();
    }

    @Test
    public void facultyOfStudentTest() {
        long numberId = 2L;
        Assertions
                .assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/student/facultyOfStudentWithId/"
                        + numberId, String.class))
                .isNotEmpty();
    }

    @Test
    public void createStudentTest() {
        long id = 8L;
        int age = 23;
        String name = "Tom";
        Student student1 = new Student();
        student1.setId(id);
        student1.setName(name);
        student1.setAge(age);
        Assertions
                .assertThat(this.testRestTemplate.postForObject("http://localhost:" + port + "/student", student1, String.class))
                .isNotNull();
    }

    @Test
    public void updateStudentTest() {
        long id = 4L;
        String name = "Kate";
        int age = 23;
        Student student2 = new Student();
        student2.setId(id);
        student2.setName(name);
        student2.setAge(age);
        HttpEntity<Student> entity = new HttpEntity<>(student2);
        ResponseEntity<Student> response = testRestTemplate.exchange( "http://localhost:" + port +"/student", HttpMethod.PUT, entity, Student.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(Objects.requireNonNull(response.getBody()).getId()).isEqualTo(id);
        Assertions.assertThat(response.getBody().getName()).isEqualTo(name);
    }

    @Test
    public void deleteStudentTest() {
        long id = 4L;
        ResponseEntity<Student> studentEntity = testRestTemplate.exchange("http://localhost:" + port + "/student/" + id,
                HttpMethod.DELETE, null, Student.class);
        Assertions.assertThat(studentEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
