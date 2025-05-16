package com.example.demo.repo;

import com.example.demo.model.User;

import java.util.List;

/**
 * Interface for a fake user repository.
 * Simulates data storage operations such as insert, find, delete, and fetch.
 */
public interface FakeRepoInterface {

    /**
     * Inserts a new user into the repository.
     *
     * @param user the user to insert
     */
    void insertUser(User user);

    /**
     * Finds a user by their ID.
     *
     * @param id the ID of the user
     * @return the found user, or null if not found
     */
    User findUserById(int id);

    /**
     * Deletes a user with the given ID.
     *
     * @param id the ID of the user to delete
     * @return true if the user was deleted, false otherwise
     */
    boolean deleteUser(int id);

    /**
     * Retrieves all users from the repository.
     *
     * @return a list of all users
     */
    List<User> getAllUsers();
}
