package com.example.spring_data_jpa.spring_data_jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring_data_jpa.spring_data_jpa.entity.StudentEntity;

import lombok.Builder;
import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        StudentEntity student = StudentEntity.builder()
                .emailId("nazmul@gmail.com")
                .firstName("nazmul")
                .lastName("hoque")

                .build();
        studentRepository.save(student);

    }

    @Test
    public void printAllStudent() {
        List<StudentEntity> studentList = studentRepository.findAll();

        System.out.println("Student List: " + studentList);
    }
}
