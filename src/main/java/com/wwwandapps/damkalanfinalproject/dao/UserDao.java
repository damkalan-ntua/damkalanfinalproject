package com.wwwandapps.damkalanfinalproject.dao;

import java.util.List;

import com.wwwandapps.damkalanfinalproject.model.User;

public interface UserDao {

    User findById(Long id);

    List<User> findAll();

    void save(User user);

    void update(User user);

    void delete(Long id);

}