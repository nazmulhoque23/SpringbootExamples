package com.example.leaveapplication.service;

import com.example.leaveapplication.dto.UserDTO;
import com.example.leaveapplication.entity.Role;
import com.example.leaveapplication.entity.User;
import com.example.leaveapplication.mappers.UserMapper;
import com.example.leaveapplication.repository.UserRepository;
import com.example.leaveapplication.utils.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        /*if (userDTO.getManager() != null
                && userDTO.getManager().getId() != null
                && userRepo.findById(userDTO.getManager().getId()).isPresent()) {
            return null;// will implement an datanotfoundexception
        }*/

        userDTO.setEmail(userDTO.getEmail());

        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userDTO.setUserName(userDTO.getUserName());

        //userDTO.setManager(userDTO.getManager());
        userDTO.setRoles(Arrays.asList(new Role(RoleEnum.USER)));

        User user = userRepo.save(UserMapper.mapToEntity(userDTO));
        UserDTO modifiedUser = UserMapper.mapToDto(user);
        return modifiedUser;
    }
}
