package com.chidiudo.userservice.controller;

import com.chidiudo.userservice.entity.User;
import com.chidiudo.userservice.service.UserService;
import dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1")
public class HomeController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @PostMapping(value = "/saveuser")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {

        User user = modelMapper.map(userDto, User.class);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }
}
