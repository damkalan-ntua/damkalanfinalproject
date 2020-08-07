package com.wwwandapps.damkalanfinalproject.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wwwandapps.damkalanfinalproject.model.*;
import com.wwwandapps.damkalanfinalproject.service.UserdetailsServiceImplementation;

@Controller
public class UserdetailsController {

    private final Logger logger = LoggerFactory.getLogger(UserdetailsController.class);

    @Autowired
    private UserdetailsServiceImplementation userdetailsServiceImplementation;


    @RequestMapping(value = "/usersandteams", method = RequestMethod.GET)
    public String usersandteams(Model model) {
        model.addAttribute("userdetails", userdetailsServiceImplementation.findAll());
        return "listusersandteams.jsp";
    }


}