package com.wwwandapps.damkalanfinalproject.controller;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.wwwandapps.damkalanfinalproject.service.UserServiceCrud;

@Controller
public class UserCrudController {

    private final Logger logger = LoggerFactory.getLogger(UserCrudController.class);

    @Autowired
    private UserServiceCrud userServicecrud;

    @GetMapping("/users/count")
    public  @ResponseBody Long count() {
        return userServicecrud.count();
    }

    // list page
    @RequestMapping(value = "/crud/users/list", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        logger.debug("showAllUsers()");
        model.addAttribute("users", userServicecrud.userAllData());
        return "listusers.jsp";
    }


    @RequestMapping(value = "/crud/users/{id}/list", method = RequestMethod.GET)
    public String showUserById(@PathVariable("id") Long id,Model model) {
        logger.debug("showUserById()");
        model.addAttribute("userr", userServicecrud.findByID(id));
        return "listuser.jsp";
    }

    // show user
    @RequestMapping(value = "/crud/users/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Long id, Model model) {
        logger.debug("showUser() id: {}", id);
        Optional user = userServicecrud.findByID(id);
        if (user == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("user", user);
        return "users/show";
    }
}