package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTests {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private User testUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        testUser = new User(1, "John Doe", "john.doe@example.com");
    }

    @Test
    void createUser_shouldReturnStatus200_whenUserIsCreated() throws Exception {
        doNothing().when(userService).addUser(any(User.class));

        mockMvc.perform(post("/api/users")
                        .contentType("application/json")
                        .content("{\"id\":1,\"name\":\"John Doe\",\"email\":\"john.doe@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("User created successfully with ID: 1"));

        verify(userService, times(1)).addUser(any(User.class));
    }

    @Test
    void fetchAllUsers_shouldReturnUsersList_whenUsersExist() throws Exception {
        List<User> users = List.of(testUser);
        when(userService.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"));

        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void fetchUserById_shouldReturnUser_whenUserExists() throws Exception {
        when(userService.getUserById(1)).thenReturn(testUser);

        mockMvc.perform(get("/api/users/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));

        verify(userService, times(1)).getUserById(1);
    }

    @Test
    void fetchUserById_shouldReturnStatus404_whenUserNotFound() throws Exception {
        when(userService.getUserById(2)).thenReturn(null);

        mockMvc.perform(get("/api/users/{id}", 2))
                .andExpect(status().isNotFound())
                .andExpect(content().string("? No user found with ID: 2"));

        verify(userService, times(1)).getUserById(2);
    }

    @Test
    void removeUser_shouldReturnStatus200_whenUserIsDeleted() throws Exception {
        when(userService.deleteUserById(1)).thenReturn(true);

        mockMvc.perform(delete("/api/users/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string("?? User with ID 1 deleted."));

        verify(userService, times(1)).deleteUserById(1);
    }

    @Test
    void removeUser_shouldReturnStatus404_whenUserNotFound() throws Exception {
        when(userService.deleteUserById(2)).thenReturn(false);

        mockMvc.perform(delete("/api/users/{id}", 2))
                .andExpect(status().isNotFound())
                .andExpect(content().string("?? User not found."));

        verify(userService, times(1)).deleteUserById(2);
    }
}
