package com.example.leaveapplication.controller;

import com.example.leaveapplication.configuration.JwTokenProvider;
import com.example.leaveapplication.configuration.JwtAuthenticationResponse;
import com.example.leaveapplication.dto.UserDTO;
import com.example.leaveapplication.entity.User;
import com.example.leaveapplication.repository.UserRepository;
import com.example.leaveapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    AuthenticationManager authManager;



    @Autowired
    UserRepository userRepository;

    @Autowired
    JwTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody User user){
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        User user1 = (User) auth.getPrincipal();
        if(user1 == null){
            Map<String, String> response = new HashMap<>();
            response.put("message", "LOCKED");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = tokenProvider.generateToken(auth);
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, String.valueOf(new JwtAuthenticationResponse(jwt))).body(user1);
    }


}
