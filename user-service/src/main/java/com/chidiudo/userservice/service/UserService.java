package com.chidiudo.userservice.service;


import com.chidiudo.userservice.entity.User;
import dto.UserDto;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> listAllUsers();

    User findById(Long postId);

    boolean deleteUser(Long postId);

    User updateUser(Long postId, UserDto userDto);

    List<User> searchForUser (String query);



}
