package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing user operations.
 * Provides endpoints for creating, retrieving, and deleting users.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructor injection for UserService.
     *
     * @param userService the user service to use
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creates a new user.
     *
     * @param user the user to create
     * @return HTTP 200 with success message
     */
    @PostMapping
    @Transactional
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok("User created successfully with ID: " + user.getId());
    }

    /**
     * Fetches all users.
     *
     * @return HTTP 200 with list of users, or 204 if empty
     */
    @GetMapping
    public ResponseEntity<List<User>> fetchAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(users);
    }

    /**
     * Fetches a user by ID.
     *
     * @param id the ID of the user
     * @return HTTP 200 with user, or 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> fetchUserById(@PathVariable int id) {
        Optional<User> user = Optional.ofNullable(userService.getUserById(id));
        return user.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .status(404)
                        .body("❌ No user found with ID: " + id));
    }

    /**
     * Deletes a user by ID.
     *
     * @param id the ID of the user to delete
     * @return HTTP 200 if deleted, or 404 if user not found
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> removeUser(@PathVariable int id) {
        boolean deleted = userService.deleteUserById(id);
        return deleted
                ? ResponseEntity.ok("🗑️ User with ID " + id + " deleted.")
                : ResponseEntity.status(404).body("⚠️ User not found.");
    }
}
