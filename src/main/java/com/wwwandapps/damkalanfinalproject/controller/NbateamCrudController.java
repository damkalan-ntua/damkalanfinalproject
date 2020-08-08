package com.wwwandapps.damkalanfinalproject.controller;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wwwandapps.damkalanfinalproject.repository.NbateamRepository;
import com.wwwandapps.damkalanfinalproject.model.Nbateam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

@Controller
public class NbateamCrudController {

    @Autowired
    private NbateamRepository NbateamRepository;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/getteamsfromNBAApi")
    public  String test() throws IOException {
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

        NbateamRepository.deleteAll();
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
        return "redirect:/nbateams/list";
    }
}