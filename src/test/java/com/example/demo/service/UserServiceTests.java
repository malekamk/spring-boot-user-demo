package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repo.FakeRepoInterface;
import org.junit.jupiter.api.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private FakeRepoInterface fakeRepo;

    @InjectMocks
    private UserServiceImpl userService;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        if (closeable != null) {
            closeable.close();
        }
    }

    @Test
    void shouldAddUserWhenUserDoesNotExist() {
        User user = new User(1, "Alice", "Smith");

        when(fakeRepo.findUserById(user.getId())).thenReturn(null);

        userService.addUser(user);

        verify(fakeRepo, times(1)).insertUser(user);
    }

    @Test
    void shouldNotAddUserWhenUserAlreadyExists() {
        User user = new User(1, "Alice", "Smith");

        when(fakeRepo.findUserById(user.getId())).thenReturn(user);

        userService.addUser(user);

        verify(fakeRepo, never()).insertUser(any(User.class));
    }

    @Test
    void shouldReturnUserWhenUserExists() {
        User user = new User(2, "Bob", "Brown");

        when(fakeRepo.findUserById(2)).thenReturn(user);

        User result = userService.getUserById(2);

        assertNotNull(result);
        assertEquals("Bob", result.getName());
    }

    @Test
    void shouldReturnNullWhenUserDoesNotExist() {
        when(fakeRepo.findUserById(99)).thenReturn(null);

        User result = userService.getUserById(99);

        assertNull(result);
    }

    @Test
    void shouldDeleteUserById() {
        when(fakeRepo.deleteUser(3)).thenReturn(true);

        boolean result = userService.deleteUserById(3);

        assertTrue(result);
    }

    @Test
    void shouldReturnAllUsers() {
        List<User> users = Arrays.asList(
                new User(1, "Anna", "White"),
                new User(2, "Tom", "Blue")
        );

        when(fakeRepo.getAllUsers()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(2, result.size());
        assertEquals("Anna", result.get(0).getName());
    }

    @Test
    void shouldReturnEmptyListWhenNoUsersExist() {
        when(fakeRepo.getAllUsers()).thenReturn(Collections.emptyList());

        List<User> result = userService.getAllUsers();

        assertTrue(result.isEmpty());
    }
}
