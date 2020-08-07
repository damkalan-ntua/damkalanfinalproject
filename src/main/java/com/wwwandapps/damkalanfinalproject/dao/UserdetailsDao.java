package com.wwwandapps.damkalanfinalproject.dao;

import java.util.List;

import com.wwwandapps.damkalanfinalproject.model.Userdetails;

public interface UserdetailsDao {

    Userdetails findById(Long id);

    List<Userdetails> findAll();

    void save(Userdetails user);

    void update(Userdetails user);

    void delete(Long id);

}