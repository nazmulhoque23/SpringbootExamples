package com.example.leaveapplication.mappers;

import com.example.leaveapplication.dto.UserDTO;
import com.example.leaveapplication.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public class UserMapper {
    public static UserDTO mapToDto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoles(user.getRoles());

        return userDTO;
    }

   /* public static UserDTO mapToDTOWithManager(User user){
        UserDTO userDTO = mapToDto(user);
        if(user.getManagerId()!=null){
            userDTO.setManager(UserMapper.mapToDto(user.getManagerId()));
        }
        return userDTO;
    }*/

    public static User mapToEntity(UserDTO userDTO){
        User user = new User();
        user.setEmail(userDTO.getEmail());



        return user;

    }
    /*public static User mapToEntityWithManager(UserDTO userDTO){
        User user = mapToEntity(userDTO);
        if(user.getManagerId()!=null){
            user.setManagerId(UserMapper.mapToEntity(userDTO.getManager()));
        }
        return user;
    }*/
}
