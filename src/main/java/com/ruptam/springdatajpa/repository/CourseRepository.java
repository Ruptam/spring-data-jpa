package com.ruptam.springdatajpa.repository;

import java.util.List;

import com.ruptam.springdatajpa.entity.Course;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository <Course, Long>{
 
    List<Course> findByTitleContaining(String str, Pageable pageable);
}
