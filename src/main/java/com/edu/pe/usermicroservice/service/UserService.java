package com.edu.pe.usermicroservice.service;

import com.edu.pe.usermicroservice.model.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    User createUser(User user);
    User updateUser(int id, User updatedUser);
    void deleteUser(int id);
    User getUserByUsernameAndPassword(String username, String password);


}
