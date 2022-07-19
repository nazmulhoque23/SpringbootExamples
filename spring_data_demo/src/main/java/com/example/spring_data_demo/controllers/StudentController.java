package com.example.spring_data_demo.controllers;

import com.example.spring_data_demo.entity.Student;
import com.example.spring_data_demo.entity.StudentProjection;
import com.example.spring_data_demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/")
    public void add(){
        studentService.save();
    }

    @GetMapping("/findAll")
    public List<Student> getAllStudent(){
        return studentService.findAllStudent();
    }

    @GetMapping("/find/{studentId}")
    public StudentProjection findById(@PathVariable Integer studentId){

        return studentService.getInfo(studentId);

        //return ("student does not exist");

    }
    @DeleteMapping("/delete")
    public void delete(){
        studentService.deleteAllStudent();
    }

}
