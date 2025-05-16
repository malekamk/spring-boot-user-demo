package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();

    User getUserById(int id);

    boolean deleteUserById(int id);
}
