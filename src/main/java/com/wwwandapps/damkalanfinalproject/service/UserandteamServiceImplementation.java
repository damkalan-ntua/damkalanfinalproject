package com.wwwandapps.damkalanfinalproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wwwandapps.damkalanfinalproject.dao.UserandteamDao;
import com.wwwandapps.damkalanfinalproject.model.Userandteam;

@Service("UserandteamServiceImplementation")
public class UserandteamServiceImplementation implements UserandteamServiceInterface {

    UserandteamDao userandteamDao;

    @Autowired
    public void setUserDao(UserandteamDao userandteamDao) {
        this.userandteamDao = userandteamDao;
    }

    @Override
    public Userandteam findById(Long id) {
        return userandteamDao.findById(id);
    }

    @Override
    public List<Userandteam> findAll() {
        return userandteamDao.findAll();
    }

    @Override
    public  List<Userandteam>  findAllwithcommonteam(Long id) {
        return userandteamDao.findAllwithcommonteam(id);
    }

    @Override
    public void saveOrUpdate(Userandteam userandteam) {
        if (findById(userandteam.getId())==null) {
            userandteamDao.save(userandteam);
        } else {
            userandteamDao.update(userandteam);
        }
    }

    @Override
    public void delete(Long id) {
        userandteamDao.delete(id);
    }

}