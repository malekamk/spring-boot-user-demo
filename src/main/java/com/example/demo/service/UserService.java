package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

/**
 * Service interface for managing users.
 */
public interface UserService {

    /**
     * Adds a new user.
     * @param user the user to add
     */
    void addUser(User user);

    /**
     * Retrieves all users.
     * @return list of users
     */
    List<User> getAllUsers();

    /**
     * Retrieves a user by ID.
     * @param id user ID
     * @return the user, or null if not found
     */
    User getUserById(int id);

    /**
     * Deletes a user by ID.
     * @param id user ID
     * @return true if deleted, false otherwise
     */
    boolean deleteUserById(int id);
}

