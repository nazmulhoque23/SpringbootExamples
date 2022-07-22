package com.example.demodto.controller;

import com.example.demodto.entity.User;
import com.example.demodto.entity.userDto;
import com.example.demodto.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private ModelMapper modelMapper;
    private final UserService userService;

    public UserController(UserService userService){
        super();
        this.userService = userService;
    }

    @GetMapping
    public List<userDto> getUsers(){
        return userService.getAllUsers().stream().map(user->modelMapper.map(user, userDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<userDto> getUserById(@PathVariable(name = "id") Long id) throws Exception {
        User user = userService.getUserById(id);

        userDto response = modelMapper.map(user, userDto.class);

        return ResponseEntity.ok().body(response);

    }

    @PostMapping
    public ResponseEntity<userDto> createUser(@RequestBody userDto userdto){
        User useRequest = modelMapper.map(userdto, User.class);
        User user = userService.createUser(useRequest);

        userDto userResponse = modelMapper.map(user, userDto.class);

        return new ResponseEntity<userDto>(userResponse, HttpStatus.CREATED);
    }


}
