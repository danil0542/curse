package com.danyamesh.curse.controller;

import com.danyamesh.curse.model.User;
import com.danyamesh.curse.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testGetAllUsers() {
        List<User> mockUsers = Arrays.asList(new User(), new User());
        Mockito.when(userService.findAll()).thenReturn(mockUsers);
        ResponseEntity<List<User>> responseEntity = userController.getAllUsers();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockUsers, responseEntity.getBody());
        Mockito.verify(userService, Mockito.times(1)).findAll();
    }

    @Test
    void testGetUserById_UserExists() {
        Long userId = 1L;
        User mockUser = new User();
        Mockito.when(userService.findById(userId)).thenReturn(Optional.of(mockUser));
        ResponseEntity<User> responseEntity = userController.getUserById(userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockUser, responseEntity.getBody());
        Mockito.verify(userService, Mockito.times(1)).findById(userId);
    }

    @Test
    void testGetUserById_UserNotFound() {
        Long userId = 1L;
        Mockito.when(userService.findById(userId)).thenReturn(Optional.empty());
        ResponseEntity<User> responseEntity = userController.getUserById(userId);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
        Mockito.verify(userService, Mockito.times(1)).findById(userId);
    }

    @Test
    void testCreateUser() {
        User userToCreate = new User();
        Mockito.when(userService.save(Mockito.any())).thenReturn(userToCreate);
        ResponseEntity<User> responseEntity = userController.createUser(userToCreate);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(userToCreate, responseEntity.getBody());
        Mockito.verify(userService, Mockito.times(1)).save(userToCreate);
    }

    @Test
    void testUpdateUser_UserExists() {
        Long userId = 1L;
        User userToUpdate = new User();
        Mockito.when(userService.findById(userId)).thenReturn(Optional.of(userToUpdate));
        ResponseEntity<Void> responseEntity = userController.updateUser(userId, userToUpdate);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Mockito.verify(userService, Mockito.times(1)).update(userToUpdate);
    }

    @Test
    void testUpdateUser_UserNotFound() {
        Long userId = 1L;
        User userToUpdate = new User();
        Mockito.when(userService.findById(userId)).thenReturn(Optional.empty());
        ResponseEntity<Void> responseEntity = userController.updateUser(userId, userToUpdate);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        Mockito.verify(userService, Mockito.never()).update(userToUpdate);
    }

    @Test
    void testDeleteUser() {
        Long userId = 1L;
        ResponseEntity<Void> responseEntity = userController.deleteUser(userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Mockito.verify(userService, Mockito.times(1)).deleteById(userId);
    }
}