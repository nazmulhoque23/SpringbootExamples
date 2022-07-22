package com.example.demodto.services;
import com.example.demodto.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(Long id) throws Exception;

    void save(User user);
}
