package com.wwwandapps.damkalanfinalproject.dao;

import java.util.List;

import com.wwwandapps.damkalanfinalproject.model.Userandteam;

public interface UserandteamDao {

    Userandteam findById(Long id);

    List<Userandteam> findAll();

    List<Userandteam>  findAllwithcommonteam(Long id);

    void save(Userandteam user);

    void update(Userandteam user);

    void delete(Long id);

}