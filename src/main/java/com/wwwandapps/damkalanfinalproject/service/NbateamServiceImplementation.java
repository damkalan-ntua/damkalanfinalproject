package com.wwwandapps.damkalanfinalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwwandapps.damkalanfinalproject.dao.NbateamDao;
import com.wwwandapps.damkalanfinalproject.model.Nbateam;

@Service("nbateamService")
public class NbateamServiceImplementation implements NbateamServiceInterface {

    NbateamDao nbateamDao;

    @Autowired
    public void setNbateamDao(NbateamDao nbateamDao) {
        this.nbateamDao = nbateamDao;
    }

    @Override
    public Nbateam findById(Long id) {
        return nbateamDao.findById(id);
    }

    @Override
    public List<Nbateam> findAll() {
        return nbateamDao.findAll();
    }

    @Override
    public Nbateam findByName(String name){return nbateamDao.findByName(name);};

    @Override
    public void delete(Long id) {
        nbateamDao.delete(id);
    }

}