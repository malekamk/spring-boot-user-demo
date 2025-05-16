package com.example.demo.repo;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeRepo implements FakeRepoInterface {
    private final List<User> users = new ArrayList<>();
    private static int counter = 1;

    @Override
    public void insertUser(User user) {
        user.setId(counter++); // auto-increment ID
        users.add(user);
    }

    @Override
    public User findUserById(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void deleteUser(int id) {
        users.removeIf(u -> u.getId() == id);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
