package com.ruptam.springdatajpa.repository;

import java.util.List;

import com.ruptam.springdatajpa.entity.Course;
import com.ruptam.springdatajpa.entity.CourseMaterial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseMaterialTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                            .title("course1").credit(5).build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                            .url("www.google.com").course(course).build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {

        List<CourseMaterial> courseMaterial = courseMaterialRepository.findAll();
        System.out.println(courseMaterial);
    }
}
