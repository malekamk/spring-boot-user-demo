package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repo.FakeRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final FakeRepoInterface repo;

    @Autowired
    public UserServiceImpl(FakeRepoInterface repo) {
        this.repo = repo;
    }

    @Override
    public void addUser(User user) {
        if (repo.findUserById(user.getId()) != null) {
            System.out.println("User already exists.");
            return;
        }
        repo.insertUser(user);
    }

    @Override
    public User getUserById(int id) {
        return repo.findUserById(id);
    }

    @Override
    public boolean deleteUserById(int id) {
        return repo.deleteUser(id);
    }
    @Override
    public List<User> getAllUsers() {
        return repo.getAllUsers();
    }
}
