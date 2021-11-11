package com.ruptam.springdatajpa.repository;

import java.util.Arrays;
import java.util.List;

import com.ruptam.springdatajpa.entity.Course;
import com.ruptam.springdatajpa.entity.CourseMaterial;
import com.ruptam.springdatajpa.entity.Student;
import com.ruptam.springdatajpa.entity.Teacher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCoursesWithCourseMaterial() {
        
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourse() {

        Teacher teacher = Teacher.builder()
                    .firstName("Priyanka").lastName("Singh").build();
        
        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.youtube.com").build();
        Course course = Course.builder()
                            .title("python")
                            .credit(6)
                            .teacher(teacher)
                            .courseMaterial(courseMaterial)
                            .build();
        courseRepository.save(course);
    }

    @Test
    public void findRecordsWithPagination() {
        Pageable pageable = PageRequest.of(0, 3);
        Page<Course> coursePage =  courseRepository.findAll(pageable);
        System.out.println(coursePage.getContent());

        long totalNumberOfElements = courseRepository.findAll(pageable).getTotalElements();
        System.out.println("Total Number of Elements => " + totalNumberOfElements);

        long totalPages = courseRepository.findAll(pageable).getTotalPages();
        System.out.println("Total Number of pages => " + totalPages);
    }


    @Test
    public void findRecordsBySorting() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("id"));

        Pageable descPageable = PageRequest.of(0, 3, Sort.by("id").descending());

        List<Course> courses = courseRepository.findAll(pageable).getContent();
        System.out.println(courses);
        List<Course> descCourses = courseRepository.findAll(descPageable).getContent();
        System.out.println(descCourses);
    }

    @Test
    public void customPagingAndSorting() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("id"));
        List<Course> courses = courseRepository.findByTitleContaining("A", pageable);
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudent() {

        Student s1 = Student.builder()
                            .firstName("Peter")
                            .lastName("Cat")
                            .emailId("peter@gmail.com")
                            .build();
        
        Student s2 = Student.builder()
                            .firstName("Mary")
                            .lastName("Thomas")
                            .emailId("Mary@gmail.com")
                            .build();

        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.howtodoinjava.com").build();
        List<Student> students = Arrays.asList(s1, s2);

        Course course = Course.builder()
                                .title("AI")
                                .credit(12)
                                .students(students)
                                .courseMaterial(courseMaterial)
                                .build();

        courseRepository.save(course);
    }
}
