package com.chidiudo.userservice.service.impl;

import com.chidiudo.userservice.entity.User;
import com.chidiudo.userservice.repository.UserRepository;
import com.chidiudo.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
