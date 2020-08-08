package com.wwwandapps.damkalanfinalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwwandapps.damkalanfinalproject.dao.UserDao;
import com.wwwandapps.damkalanfinalproject.model.User;

@Service("userService")
public class UserServiceImplementation implements UserServiceInterface {

    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void add(User user) { userDao.add(user); }

    @Override
    public void saveOrUpdate(User user) {
        if (findById(user.getId())==null) {
            userDao.save(user);
        } else {
            userDao.update(user);
        }
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

}