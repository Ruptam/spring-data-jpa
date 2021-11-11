package com.ruptam.springdatajpa.repository;

import java.util.List;

import com.ruptam.springdatajpa.entity.Course;
import com.ruptam.springdatajpa.entity.CourseMaterial;
import com.ruptam.springdatajpa.entity.Teacher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacherTest() {

        CourseMaterial courseMaterial = CourseMaterial.builder()
                                                .url("www.tutorialspoint.com")
                                                .build();

        Course course = Course.builder()
                            .credit(4)
                            .title("course2")
                            .courseMaterial(courseMaterial)
                            .build();
        

        Course course2 = Course.builder()
                            .credit(3)
                            .courseMaterial(courseMaterial)
                            .title("course3")
                            .build();

        Teacher teacher = Teacher.builder()
                                .firstName("Peter")
                                .lastName("Max")
                               // .courses(List.of(course, course2))
                                .build();
            
        teacherRepository.save(teacher);
    }
}
