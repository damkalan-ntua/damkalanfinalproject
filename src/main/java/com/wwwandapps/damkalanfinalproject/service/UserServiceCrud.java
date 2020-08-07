package com.wwwandapps.damkalanfinalproject.service;

import com.wwwandapps.damkalanfinalproject.model.*;
import com.wwwandapps.damkalanfinalproject.model.*;
import com.wwwandapps.damkalanfinalproject.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
public class UserServiceCrud {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    EntityManagerFactory emf;

    public Long count() {
        return userRepository.count();
    }

    public Optional findByID(Long userId) {
        return userRepository.findById(userId);
    }

    public List<Userdetails> usersandtheirteams()
    {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select " +"s.id,s.firstName,s.email,s.city,d.fullname, s.nbateamid from User s " +"left join Nbateam d on s.nbateamid=d.id");
        @SuppressWarnings("unchecked")
        List<Userdetails> list =(List<Userdetails>)query.getResultList();
        em.close();
        return list;
    }

    public List<User> userAllData()
    {
        return userRepository.findAll();
    }

}







