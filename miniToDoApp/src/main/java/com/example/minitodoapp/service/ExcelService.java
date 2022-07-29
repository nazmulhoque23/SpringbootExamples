package com.example.minitodoapp.service;

import com.example.minitodoapp.entity.Todo;
import com.example.minitodoapp.excel.ExcelHelper;
import com.example.minitodoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {
    @Autowired
    TodoRepository repo;

    public void save(MultipartFile file){
        try{
            List<Todo> todos = ExcelHelper.excelToTodo(file.getInputStream());
            repo.saveAll(todos);
        }catch(IOException e){
            throw new RuntimeException("FAIL TO STORE EXCEL DATA"+e.getMessage());
        }
    }
    public List<Todo> getAllTutorials(){
        return repo.findAll();
    }
}
