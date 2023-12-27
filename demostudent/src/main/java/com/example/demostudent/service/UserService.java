package com.example.demostudent.service;

import com.example.demostudent.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO updatedUserDTO);
    void deleteUser(Long id);
}
