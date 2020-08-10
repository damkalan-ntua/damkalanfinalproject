package com.wwwandapps.damkalanfinalproject.service;

import com.wwwandapps.damkalanfinalproject.model.*;
import com.wwwandapps.damkalanfinalproject.repository.UserRepositoryCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.persistence.EntityManagerFactory;

@Service
public class UserServiceCrud {

    @Autowired
    private UserRepositoryCrud userRepositoryCrud;

    @Autowired
    EntityManagerFactory emf;

    public Long count() {
        return userRepositoryCrud.count();
    }

    public List<User> userAllData()
    {
        return userRepositoryCrud.findAll();
    }

}







