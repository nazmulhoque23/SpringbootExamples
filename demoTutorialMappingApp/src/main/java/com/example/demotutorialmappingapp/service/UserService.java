package com.example.demotutorialmappingapp.service;

import com.example.demotutorialmappingapp.dto.UserRegistrationDto;
import com.example.demotutorialmappingapp.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserEntity save(UserRegistrationDto registrationDto);
    List<UserEntity> getAll();
}
