package com.example.demodto.services;

import java.util.*;
import java.lang.*;

import com.example.demodto.repository.RoleRepository;
import com.example.demodto.repository.UserRepository;
import com.example.demodto.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws Exception {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        else{
            throw new Exception("NOT FOUND");
        }
    }

    @Override
    public void save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<> (roleRepository.findAll()));
        userRepository.save(user);
    }


}
