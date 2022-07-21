package com.example.basicloginapp.controllers;

import com.example.basicloginapp.entity.User;
import com.example.basicloginapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm){
        userService.save(userForm);

        return "redirect:/welcome";
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
