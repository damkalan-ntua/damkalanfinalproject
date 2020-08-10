package com.wwwandapps.damkalanfinalproject.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.wwwandapps.damkalanfinalproject.model.User;
import com.wwwandapps.damkalanfinalproject.service.UserServiceInterface;

@Controller
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceInterface userService;

    @RequestMapping(value = "/users/list", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        logger.debug("showAllUsers()");
        model.addAttribute("users", userService.findAll());
        return "listusers.jsp";
    }

    @RequestMapping(value = "/users/{id}/list", method = RequestMethod.GET)
    public String showUserById(@PathVariable("id") Long id,Model model) {
        logger.debug("showUserById()");
        model.addAttribute("user", userService.findById(id));
        return "listuser.jsp";
    }

    // show add user form
    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String showAddUserForm(@ModelAttribute("user") @Validated User user,Model model) {
        logger.debug("showAddUserForm()");
        model.addAttribute("user", user);
        System.out.println(user.getFirstName());
        return "newuserform.jsp";
    }

    @RequestMapping(value = "/users/addsubmit", method = RequestMethod.POST)
    public String submitAddUserForm(@ModelAttribute("user") @Validated User user,  BindingResult result, Model model) {
        logger.debug("submitAddUserForm()  " );
        userService.add(user);
        return "redirect:/users/list";
    }

    // show update form
    @RequestMapping(value = "/users/{id}/update", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable("id") Long id, Model model) {
        logger.debug("showUpdateUserForm() : {}", id);
        model.addAttribute("user", userService.findById(id));
        return "userform.jsp";
    }

    @RequestMapping(value = "/users/updatesubmit", method = RequestMethod.POST)
    public String submitUpdateUserForm(@ModelAttribute("user") @Validated User user,  BindingResult result, Model model) {
        logger.debug("submitUpdateUserForm()  " );
        userService.saveOrUpdate(user);
        return "redirect:/users/list";
    }

    // delete user
     @RequestMapping(value = "/users/{id}/delete", method = RequestMethod.GET)
    public String deleteUserById(@PathVariable("id") Long id,Model model) {
        logger.debug("deleteUserById()");
        userService.delete(id);
        return "redirect:/users/list";
    }

    // show user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Long id, Model model) {
        logger.debug("showUser() id: {}", id);
        User user = userService.findById(id);
        if (user == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("user", user);
        return "users/show";
    }
}