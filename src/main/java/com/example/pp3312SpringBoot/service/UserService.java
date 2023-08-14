package com.example.pp3312SpringBoot.service;

import com.example.pp3312SpringBoot.entity.User;


import java.util.List;

public interface UserService {

    void add(User user);
    void updateUser(User user);
    void deleteUserFromTable(Long id);
    List<User> getAllUsers();
    User findById(Long id);
}