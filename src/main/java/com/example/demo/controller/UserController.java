package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok("User created successfully with ID: " + user.getId());
    }

    @GetMapping
    public ResponseEntity<List<User>> fetchAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchUserById(@PathVariable int id) {
        Optional<User> user = Optional.ofNullable(userService.getUser(id));
        return user.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .status(404)
                        .body("❌ No user found with ID: " + id));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> removeUser(@PathVariable int id) {
        boolean deleted = userService.removeUser(id);
        return deleted
                ? ResponseEntity.ok("🗑️ User with ID " + id + " deleted.")
                : ResponseEntity.status(404).body("⚠️ User not found.");
    }
}
