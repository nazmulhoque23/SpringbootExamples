package com.example.spring_data_demo.services;

import com.example.spring_data_demo.entity.Student;
import com.example.spring_data_demo.entity.StudentProjection;
import com.example.spring_data_demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentServiceInterface{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudent() {
        return (List<Student>) studentRepository.findAll();

    }

    @Override
    public StudentProjection getInfo(Integer studentId) {
        return studentRepository.getInfo(studentId);


    }
    @Override
    public void save() {
        ArrayList<Student> student = new ArrayList<Student>();
        student.add(new Student(1, "Nazmul", "hoque", "naz@gmail.com"));
        student.add(new Student(2, "sazzad", "Puneet","saz@gmail.com"));
        student.add(new Student(3, "jahir", "Abhay","jahir@gmail.com"));
        student.add(new Student(4,"shawon", "Anurag","shawon@gmail.com"));

        for (Student s : student) {
            studentRepository.save(s);
        }
    }

    @Override
    public void deleteAllStudent() {
        studentRepository.deleteAll();
    }
}
