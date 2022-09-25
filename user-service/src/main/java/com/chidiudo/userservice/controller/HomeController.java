package com.chidiudo.userservice.controller;

import com.chidiudo.userservice.entity.User;
import com.chidiudo.userservice.security.UserDetailsImpl;
import com.chidiudo.userservice.service.UserService;
import dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class HomeController {


    @Autowired
    private UserService userService;



    @GetMapping(value = "/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<> ("Hello there !", HttpStatus.OK);
    }

    @PostMapping(value = "/saveuser")
    public ResponseEntity<?> saveUser(@RequestBody User user) {

        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @GetMapping(value = "/listallusers")
    public ResponseEntity<List<User>> listAllUsers() {

        return new ResponseEntity<>(userService.listAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "getbypage/{page}")
    public ResponseEntity<List<User>> listUsersByPage(@PathVariable(value = "page") int page) {

        return new ResponseEntity<>(userService.listByPage(page), HttpStatus.OK);
    }

    @GetMapping(value = "/userbyid")
    public ResponseEntity<?> findUserById(@RequestParam(value = "postid") Long postId) {

        return new ResponseEntity<>(userService.findById(postId), HttpStatus.OK);
    }

    @GetMapping(value = "/userbylastname/{lastname}")
    public ResponseEntity<List<User>> findUserByLastName(@PathVariable(value = "lastname") String name) {

        return new ResponseEntity<>(userService.findByLastName(name), HttpStatus.OK);
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
    public ResponseEntity<List<User>> searchForUser(@RequestParam(value = "query") String query) {

        return new ResponseEntity(userService.searchForUser(query), HttpStatus.OK);
    }
}
