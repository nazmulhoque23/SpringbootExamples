package com.example.demo.spring_demo_example.controller;


import com.example.demo.spring_demo_example.entity.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @GetMapping("/users")
    public ResponseEntity<List<User>> users(){
        List<User> users = new ArrayList<User>();
        users.add(new User(1,"Nazmul"));
        users.add(new User(2,"Jubayed"));
        users.add(new User(1,"Sazzad"));


        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "UserController");
        return ResponseEntity.accepted().headers(headers).body(users);
    }

    @GetMapping("/user1")
    @ResponseBody
    public List<User> user1(){
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "Ramesh"));
        users.add(new User(2, "Tony"));
        users.add(new User(3, "Tom"));
        return users;
    }

    @GetMapping("/user1/{name}")
    public String userList(@PathVariable String name){
        List<User> users = new ArrayList<User>();

        users.add(new User(1, "Ramesh"));
        users.add(new User(2, "Tony"));
        users.add(new User(3, "Tom"));


            for(int i =0; i<users.size();i++){
                if(name.equals(users.get(i).getName())){
                return users.get(i).getName();

            }


        }
        //return ResponseEntity.ok().body(users.stream().filter(u->u.getName().equals(name)).findFirst().orElseThrow(()->new IllegalStateException("User: "+name+"Does not exist")));
        //String u = users.get(1).getName();
        return ("User does not exist");


    }

    //@GetMapping("/users/")
}
