package com.chidiudo.userservice.controller;

import com.chidiudo.userservice.entity.User;
import com.chidiudo.userservice.service.UserService;
import dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/listallusers")
    public ResponseEntity<List> listAllUsers() {

        return new ResponseEntity<>(userService.listAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/userbyid")
    public ResponseEntity<?> findUserById(@RequestParam(value = "postid") Long postId) {

        return new ResponseEntity<>(userService.findById(postId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteuser")
    public ResponseEntity deleteUser(@RequestParam(value = "postid") Long postId) {

        return new ResponseEntity(userService.deleteUser(postId), HttpStatus.OK);
    }

    @PutMapping(value = "/updateuser")
    public ResponseEntity updateUser(@RequestParam(value = "postid") Long postId,
                                     @RequestBody UserDto userDto) {

        return new ResponseEntity(userService.updateUser(postId, userDto), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List> searchForUser(@RequestParam(value = "query") String query) {

        return new ResponseEntity(userService.searchForUser(query), HttpStatus.OK);
    }
}
