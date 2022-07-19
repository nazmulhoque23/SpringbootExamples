package com.example.spring_data_jpa.spring_data_jpa.repository;

import com.example.spring_data_jpa.spring_data_jpa.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    void delete(StudentEntity deleted);
    List<StudentEntity> findAll();
    Optional<StudentEntity> findOne(Long id);
    StudentEntity save(StudentEntity persisted);
}
