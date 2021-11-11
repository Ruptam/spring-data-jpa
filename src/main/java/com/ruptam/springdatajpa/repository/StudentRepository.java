package com.ruptam.springdatajpa.repository;

import java.util.List;
import java.util.Optional;

import com.ruptam.springdatajpa.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    

    //JPQL works on Class not on Table.
    @Query("select s from Student s where s.emailId = ?1")
    List<Student> getStudentByEmailID(String email);

    @Query(value = "select * from tbl_student where email_address = :emailId", nativeQuery = true)
    Optional<Student> getStudentByEmailIdNamedQuery(@Param("emailId") String email);

    @Modifying
    @Transactional //this annotation should be defined in service layer
    @Query(value = "update tbl_student set first_name= :firstName where email_address= :emailId", nativeQuery = true)
    int modifyFirstNameUsingEmailId(@Param("firstName") String firstName, 
        @Param("emailId") String emailId);
}
