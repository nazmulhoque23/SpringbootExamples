package com.example.basicloginapp.controllers;

import com.example.basicloginapp.entity.User;
import com.example.basicloginapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registration(Model model){
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User user, BindingResult result){
        if(result.hasErrors()){
            return "registration";
        }
        userService.save(user);

        return "welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout){
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/","/welcome"})
    public String welcome(Model model){
        return "welcome";
    }

}
