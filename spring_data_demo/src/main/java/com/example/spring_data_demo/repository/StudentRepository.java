package com.example.spring_data_demo.repository;

import com.example.spring_data_demo.entity.Student;
import com.example.spring_data_demo.entity.StudentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //List<Student> findAllStudent();
    @Query(value = "SELECT s.email_address as emailAddress, s.first_name as firstname FROM tbl_student s where s.student_id = :studentId", nativeQuery = true)
    public StudentProjection getInfo(Integer studentId);

}
