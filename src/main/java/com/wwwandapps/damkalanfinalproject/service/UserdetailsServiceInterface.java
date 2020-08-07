package com.wwwandapps.damkalanfinalproject.service;

import java.util.List;
import com.wwwandapps.damkalanfinalproject.model.Userdetails;

public interface UserdetailsServiceInterface {

    Userdetails findById(Long id);

    List<Userdetails> findAll();

    void saveOrUpdate(Userdetails userdetails);

    void delete(Long id);

}