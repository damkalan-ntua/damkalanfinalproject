package com.wwwandapps.damkalanfinalproject.repository;
import org.springframework.data.repository.CrudRepository;
import com.wwwandapps.damkalanfinalproject.model.Nbateam;

import java.util.List;


public interface NbateamRepository extends CrudRepository<Nbateam, Long> {
    @Override
    public List<Nbateam> findAll();
}