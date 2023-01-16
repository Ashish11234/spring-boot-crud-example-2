package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.User;
import com.javatechie.crud.example.entity.UserDetails;
import com.javatechie.crud.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    // to save the object

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String save(@RequestBody UserDetails userDetails){
        userService.save(userDetails);
        return "user details saved successfully";
    }


    @GetMapping("/get/{id}")
    public List<UserDetails> get(@PathVariable int id) throws Exception {
        return userService.getRecords(0,id);
    }

    @GetMapping("/getage/{age}")
    public List<User> getAge(@PathVariable int age) throws Exception {
        return userService.findAge(age);
    }

}