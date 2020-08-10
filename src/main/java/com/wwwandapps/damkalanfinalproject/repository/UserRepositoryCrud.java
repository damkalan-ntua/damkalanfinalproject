package com.wwwandapps.damkalanfinalproject.repository;

import org.springframework.data.repository.CrudRepository;
import com.wwwandapps.damkalanfinalproject.model.User;
import java.util.List;

public interface UserRepositoryCrud extends CrudRepository<User, Long> {

    @Override
    public List<User> findAll();


}