package com.aleksandartokarev.testcontainers.controllers;

import com.aleksandartokarev.testcontainers.dao.UserRepository;
import com.aleksandartokarev.testcontainers.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
