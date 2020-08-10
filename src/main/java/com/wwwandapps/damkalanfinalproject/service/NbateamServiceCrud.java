package com.wwwandapps.damkalanfinalproject.service;
import com.wwwandapps.damkalanfinalproject.repository.NbateamRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NbateamServiceCrud {

    @Autowired
    private NbateamRepositoryCrud nbateamRepository;
}