package com.example.demo.model;

/**
 * Represents a user in the system with an ID, name, and surname.
 */
//@Entity // if you're using a database and JPA
public class User {

    /** Unique identifier for the user */
    private int id;

    /** First name of the user */
    private String name;

    /** Last name (surname) of the user */
    private String surname;

    /**
     * Constructs a new User with the specified ID, name, and surname.
     *
     * @param id the unique ID of the user
     * @param name the user's first name
     * @param surname the user's last name
     */
    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    /**
     * Returns the user's ID.
     * @return the ID of the user
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user's ID.
     * @param id the new ID to assign
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the user's first name.
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's first name.
     * @param name the new name to assign
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the user's surname.
     * @return the surname of the user
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the user's surname.
     * @param surname the new surname to assign
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
