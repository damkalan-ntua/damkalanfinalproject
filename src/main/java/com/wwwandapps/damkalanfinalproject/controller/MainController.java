package com.wwwandapps.damkalanfinalproject.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wwwandapps.damkalanfinalproject.dom.UserDetails;
import com.wwwandapps.damkalanfinalproject.model.*;
import com.wwwandapps.damkalanfinalproject.repository.NbateamRepository;
import com.wwwandapps.damkalanfinalproject.service.*;
import com.wwwandapps.damkalanfinalproject.model.Nbateam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {

  @Autowired
  private UserService userService;
  @Autowired
  private NbateamRepository NbateamRepository;





  @GetMapping("/users")
  public List<User> allUsers() {

    return userService.userAllData();
  }


  @GetMapping("/usersandteams")
  public List<UserDetails> usersandteams() {

    return userService.usersandtheirteams();
  }


  @GetMapping("/users/count")
  public Long count() {

    return userService.count();
  }

  @DeleteMapping("/users/{id}")
  public void delete(@PathVariable String id) {

    Long userId = Long.parseLong(id);
    userService.deleteById(userId);
  }


  @Autowired
  ObjectMapper objectMapper;

  @GetMapping("/getteamsfromNBAApi")
  public String test() throws IOException {
    String url="https://free-nba.p.rapidapi.com/teams";
    RestTemplate restTemplate = new RestTemplate();

    // create headers
    HttpHeaders headers = new HttpHeaders();

    // example of custom header
    headers.set("x-rapidapi-host", "free-nba.p.rapidapi.com");
    headers.set("x-rapidapi-key", "b14125264dmsh0d7147c68ab0cd8p1e67b8jsnaef4f8b5cc9c");


    // build the request
    HttpEntity request = new HttpEntity(headers);

    // make an HTTP GET request with headers
    ResponseEntity<String> resp = restTemplate.exchange(
            url,
            HttpMethod.GET,
            request,
            String.class,
            1
    );


    String responseStr = resp.getBody();
    int begin = responseStr.indexOf("{");
    int end = responseStr.lastIndexOf("}") + 1;
    responseStr = responseStr.substring(begin, end);


    JsonNode arrNode = new ObjectMapper().readTree(responseStr).get("data");

    if (arrNode.isArray()) {
      for (final JsonNode objNode : arrNode) {
        System.out.println(objNode.toString());
        Nbateam tempteam = objectMapper.readValue(objNode.toString(), Nbateam.class);
        tempteam.setFullname(objNode.get("full_name").toString());
        System.out.println( tempteam.getFullname());
        NbateamRepository.save(tempteam);
      }
    }



  return "ok";
  }




  }