package com.example.spring_data_demo.services;

import com.example.spring_data_demo.entity.Student;
import com.example.spring_data_demo.entity.StudentProjection;

import java.util.List;

public interface StudentServiceInterface {
    void deleteAllStudent();
    List<Student> findAllStudent();
    public StudentProjection getInfo(Integer studentId);
    void save();
}
