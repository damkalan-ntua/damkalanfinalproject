package com.wwwandapps.damkalanfinalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwwandapps.damkalanfinalproject.dao.UserdetailsDao;
import com.wwwandapps.damkalanfinalproject.model.Userdetails;

@Service("UserdetailsServiceImplementation")
public class UserdetailsServiceImplementation implements UserdetailsServiceInterface {

    UserdetailsDao userdetailsDao;

    @Autowired
    public void setUserDao(UserdetailsDao userdetailsDao) {
        this.userdetailsDao = userdetailsDao;
    }

    @Override
    public Userdetails findById(Long id) {
        return userdetailsDao.findById(id);
    }

    @Override
    public List<Userdetails> findAll() {
        return userdetailsDao.findAll();
    }

    @Override
    public void saveOrUpdate(Userdetails userdetails) {

        if (findById(userdetails.getId())==null) {
            userdetailsDao.save(userdetails);
        } else {
            userdetailsDao.update(userdetails);
        }

    }

    @Override
    public void delete(Long id) {
        userdetailsDao.delete(id);
    }

}