package com.chidiudo.userservice.controller;

import com.chidiudo.userservice.entity.User;
import com.chidiudo.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1")
public class HomeController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/save")
    public User saveUser(User user) {
        return userService.saveUser(user);
    }
}
