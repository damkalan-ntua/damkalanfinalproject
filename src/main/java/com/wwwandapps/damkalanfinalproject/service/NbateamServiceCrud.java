package com.wwwandapps.damkalanfinalproject.service;

import com.wwwandapps.damkalanfinalproject.model.Nbateam;
import com.wwwandapps.damkalanfinalproject.model.User;
import com.wwwandapps.damkalanfinalproject.repository.NbateamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NbateamServiceCrud {

    @Autowired
    private NbateamRepository nbateamRepository;


}