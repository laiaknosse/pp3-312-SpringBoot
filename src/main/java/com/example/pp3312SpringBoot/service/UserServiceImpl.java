package com.example.pp3312SpringBoot.service;


import com.example.pp3312SpringBoot.dao.UserDao;
import com.example.pp3312SpringBoot.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {

        userDao.add(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {

        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUserFromTable(Long id) {

        userDao.deleteUserFromTable(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public User findById(Long id) {

        return userDao.findById(id);
    }
}