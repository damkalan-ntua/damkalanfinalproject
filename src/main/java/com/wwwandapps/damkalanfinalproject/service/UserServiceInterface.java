package com.wwwandapps.damkalanfinalproject.service;

import java.util.List;
import com.wwwandapps.damkalanfinalproject.model.User;

public interface UserServiceInterface {

    User findById(Long id);

    List<User> findAll();

    void add(User user);

    void saveOrUpdate(User user);

    void delete(Long id);

}