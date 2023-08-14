package com.example.pp3312SpringBoot.dao;

import com.example.pp3312SpringBoot.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {

        entityManager.persist(user);
    }

    @Override
    public User updateUser(User user) {

        return entityManager.merge(user);
    }

    @Override
    public void deleteUserFromTable(Long id) {

        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User findById(Long id) {

        return entityManager.find(User.class, id);
    }
}