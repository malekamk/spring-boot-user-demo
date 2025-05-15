package com.example.demo.repo;

import com.example.demo.model.User;

public interface FakeRepoInterface {
    void insertUser(User user);
    User findUserById(int id);
    void deleteUser(int id);
}
