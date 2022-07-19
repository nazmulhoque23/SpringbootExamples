package com.example.demo.spring_demo_example.services;

import java.util.HashSet;
import java.util.List;

import com.example.demo.spring_demo_example.entity.User;
public interface UserService {
    List<User> findAllUser();
    User findByName(String name);
    void addUser(User user);
    void deleteUser();
}
