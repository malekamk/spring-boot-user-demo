package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    void addUser(User user);
    User getUser(int id);
    void removeUser(int id);
}
