package com.wwwandapps.damkalanfinalproject.service;

import com.wwwandapps.damkalanfinalproject.model.User;
import com.wwwandapps.damkalanfinalproject.repository.UserRepository;
import com.wwwandapps.damkalanfinalproject.dom.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    EntityManagerFactory emf;


    public Long count() {

        return userRepository.count();
    }

    public void deleteById(Long userId) {

        userRepository.deleteById(userId);
    }


    public List<UserDetails> usersandtheirteams()
    {
        EntityManager em = emf.createEntityManager();


        Query query = em.createQuery("Select " +"s.id,s.firstName,s.email,s.city,d.fullname from User s " +"left join Nbateam d on s.nbateamid=d.id");
        @SuppressWarnings("unchecked")
        List<UserDetails> list =(List<UserDetails>)query.getResultList();

        em.close();

        return list;

    }

    public List<User> userAllData()
    {
        return userRepository.findAll();
    }

}







