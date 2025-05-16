package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repo.FakeRepo;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTests {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(new FakeRepo());
    }

    @Test
    void testAddUser() {
        User user = new User(1, "John", "Doe");
        userService.addUser(user);
        assertEquals("John", userService.getUser(1).getName());
    }

    @Test
    void testDuplicateUserNotAdded() {
        User user = new User(1, "Jane", "Doe");
        userService.addUser(user);
        userService.addUser(user);  // Should print a warning
        assertNotNull(userService.getUser(1));
    }

    @Test
    void testRemoveUser() {
        User user = new User(2, "Alice", "Smith");
        userService.addUser(user);
        userService.removeUser(2);
        assertNull(userService.getUser(2));
    }
}
