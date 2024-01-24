package com.danyamesh.curse.service;

import com.danyamesh.curse.model.User;
import com.danyamesh.curse.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testCreateUser() {
        User userToSave = new User();
        when(userRepository.save(any(User.class))).thenReturn(userToSave);
        User savedUser = userService.save(userToSave);
        assertNotNull(savedUser);
        verify(userRepository, times(1)).save(userToSave);
    }

    @Test
    void testGetUserById() {
        Long userId = 1L;
        User user = new User();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        User foundUser = userService.findById(userId).orElseThrow();
        assertNotNull(foundUser);
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void testGetAllUsers() {
        List<User> userList = Arrays.asList(
                new User(),
                new User()
        );
        when(userRepository.findAll()).thenReturn(userList);
        List<User> allUsers = userService.findAll();
        assertNotNull(allUsers);
        assertEquals(userList.size(), allUsers.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testUpdateUser() {
        User userToUpdate = new User();
        userService.update(userToUpdate);
        verify(userRepository, times(1)).save(userToUpdate);
    }

    @Test
    void testDeleteUser() {
        User userToDelete = new User();
        userService.delete(userToDelete);
        verify(userRepository, times(1)).delete(userToDelete);
    }

    @Test
    void testDeleteUserById() {
        Long userId = 1L;
        userService.deleteById(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }
}