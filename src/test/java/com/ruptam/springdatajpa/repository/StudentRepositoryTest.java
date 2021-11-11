package com.ruptam.springdatajpa.repository;

import java.util.List;
import java.util.Optional;

import com.ruptam.springdatajpa.entity.Gurdian;
import com.ruptam.springdatajpa.entity.Student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                    .firstName("Ruptam")
                    .lastName("Sadhukhan")
                    .emailId("ruptam25@outlook.com")
                    .build();

        studentRepository.save(student);
    }

    @Test
    public void getStudents() {
        List<Student> allStudents = studentRepository.findAll();
        System.out.println(allStudents);
    }

    @Test
    public void saveStudentWithGurdian() {
        Gurdian gurdian = Gurdian.builder()
                .email("gurdian@gmail.com")
                .name("Peter")
                .phoneNumber("9999991234")
                .build();

        Student student = Student.builder()
                .firstName("John")
                .lastName("Wilson")
                .emailId("john@gmail.com")
                .gurdian(gurdian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void studentByEmailIdTest() {
        List<Student> students = studentRepository.getStudentByEmailID("ruptam25@outlook.com");
        System.out.println(students);
    }

    @Test
    public void namedQueryDemo() {
        Optional<Student> optionalStudent = 
            studentRepository.getStudentByEmailIdNamedQuery("ruptam25@outlook.com");
        
        if (optionalStudent.isPresent()) {
            System.out.println(optionalStudent.get());
        }
    }

    @Test
    public void updateRecordTest() {
        int status = studentRepository.modifyFirstNameUsingEmailId("Bapan", "ruptam25@outlook.com");
        System.out.println(status);
    }
}
