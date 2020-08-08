package com.wwwandapps.damkalanfinalproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.wwwandapps.damkalanfinalproject.model.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    public List<User> findAll();


}