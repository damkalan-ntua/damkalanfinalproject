package com.wwwandapps.damkalanfinalproject.dao;

import java.util.List;

import com.wwwandapps.damkalanfinalproject.model.Nbateam;

public interface NbateamDao {

    Nbateam findById(Long id);
    Nbateam findByName(String name);

    List<Nbateam> findAll();

    void update(Nbateam nbateam);

    void delete(Long id);

}