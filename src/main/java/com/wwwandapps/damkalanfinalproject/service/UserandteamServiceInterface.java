package com.wwwandapps.damkalanfinalproject.service;

import java.util.List;
import com.wwwandapps.damkalanfinalproject.model.Userandteam;

public interface UserandteamServiceInterface {

    Userandteam findById(Long id);

    List<Userandteam> findAll();

    List<Userandteam>  findAllwithcommonteam(Long id);

    void saveOrUpdate(Userandteam userandteam);

    void delete(Long id);

}