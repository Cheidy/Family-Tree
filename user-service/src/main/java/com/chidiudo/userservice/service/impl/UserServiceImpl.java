package com.chidiudo.userservice.service.impl;

import com.chidiudo.userservice.entity.User;
import com.chidiudo.userservice.repository.UserRepository;
import com.chidiudo.userservice.service.UserService;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long postId) {
        return userRepository.findById(postId).get();
    }

    @Override
    public boolean deleteUser(Long postId) {

         userRepository.deleteById(postId);

         return true;
    }

    @Override
    public User updateUser(Long postId, UserDto userDto) {
        User user = userRepository.findById(postId).get();

        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setPhonenumber(userDto.getPhonenumber());

        return userRepository.save(user);
    }

    @Override
    public List<User> searchForUser(String query) {

        return userRepository.searchUsers(query);

    }


}
