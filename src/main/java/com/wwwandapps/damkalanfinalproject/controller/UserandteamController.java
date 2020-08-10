package com.wwwandapps.damkalanfinalproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.wwwandapps.damkalanfinalproject.service.UserandteamServiceImplementation;

@Controller
public class UserandteamController {

    private final Logger logger = LoggerFactory.getLogger(UserandteamController.class);

    @Autowired
    private UserandteamServiceImplementation UserandteamServiceImplementation;

    @RequestMapping(value = "/usersandteams", method = RequestMethod.GET)
    public String usersandteams(Model model) {
        model.addAttribute("userandteam", UserandteamServiceImplementation.findAll());
        return "listusersandteams.jsp";
    }


    @RequestMapping(value = "/usersandteams/sameteam/{id}/list", method = RequestMethod.GET)
    public String usersandteamscommon(@PathVariable("id") Long id,Model model) {
        logger.debug("showNbateamById()");
        model.addAttribute("userandteam", UserandteamServiceImplementation.findAllwithcommonteam(id));
        return "listusersandteams.jsp";
    }
}