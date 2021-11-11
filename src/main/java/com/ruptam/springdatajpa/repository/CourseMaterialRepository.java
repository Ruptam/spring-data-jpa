package com.ruptam.springdatajpa.repository;

import com.ruptam.springdatajpa.entity.CourseMaterial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long>{
    
    
}
