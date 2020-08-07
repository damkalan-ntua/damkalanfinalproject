package com.wwwandapps.damkalanfinalproject.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wwwandapps.damkalanfinalproject.model.*;
import com.wwwandapps.damkalanfinalproject.repository.NbateamRepository;
import com.wwwandapps.damkalanfinalproject.service.*;
import com.wwwandapps.damkalanfinalproject.model.Nbateam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

  @Autowired
  private UserServiceCrud userServiceCrud;
  @Autowired
  private NbateamRepository NbateamRepository;

  private final Logger logger = LoggerFactory.getLogger(MainController.class);

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {
    logger.debug("index()");
    return "redirect:/home";
  }

  @RequestMapping("/home")
  public String home() {
    System.out.println("hi");
    return "home.jsp";
  }


  @RequestMapping(value = "/users/crud/{id}", method = RequestMethod.GET)

    public String showUser(@PathVariable("id") Long id, Model model) {
    Optional user = userServiceCrud.findByID(id);
    if (user == null) {
      model.addAttribute("css", "danger");
      model.addAttribute("msg", "User not found");
    }
    model.addAttribute("user", user);
    return "showusers";
  }

}