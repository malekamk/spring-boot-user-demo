package com.example.demo.repo;

import com.example.demo.model.User;

import java.util.List;

public interface FakeRepoInterface {
    void insertUser(User user);
    User findUserById(int id);
    void deleteUser(int id);
    List<User> getAllUsers();
}
