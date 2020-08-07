package com.wwwandapps.damkalanfinalproject.service;

import java.util.List;
import com.wwwandapps.damkalanfinalproject.model.Nbateam;

public interface NbateamServiceInterface {
    Nbateam findById(Long id);
    Nbateam findByName(String name);
    List<Nbateam> findAll();
    void saveOrUpdate(Nbateam nbateam);
    void delete(Long id);

}