package com.example.basicloginapp.services;

import com.example.basicloginapp.entity.User;

public interface UserService {
    void save(User user);

    User findByName(String name);


}
