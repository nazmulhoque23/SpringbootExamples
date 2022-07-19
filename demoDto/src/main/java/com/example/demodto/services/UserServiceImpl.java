package com.example.demodto.services;

import java.util.*;
import java.lang.*;
import com.example.demodto.repository.UserRepository;
import com.example.demodto.entity.User;
import com.example.demodto.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

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
}
