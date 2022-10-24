package com.test.userservice2.service;

import com.test.userservice2.domain.User;

import java.util.List;

public interface UserService {
    User saveUser (User user);
    User getUser (String username);
    List<User> getUsers();
}
