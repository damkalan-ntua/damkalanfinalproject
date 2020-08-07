package com.wwwandapps.damkalanfinalproject.repository;

import com.wwwandapps.damkalanfinalproject.model.User;
import org.springframework.data.repository.CrudRepository;
import com.wwwandapps.damkalanfinalproject.model.Nbateam;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


//The UserRepository extends from the CrudRepository. It provides the type of the entity and of its primary key.
public interface NbateamRepository extends CrudRepository<Nbateam, Long> {

    @Override
    public List<Nbateam> findAll();
}