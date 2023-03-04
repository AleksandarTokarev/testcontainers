package com.aleksandartokarev.testcontainers.dao;

import com.aleksandartokarev.testcontainers.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getUsers();

    Long createUser(User user);

    User getUser(Long id);

    void deleteUser(Long id);
}
