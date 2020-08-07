package com.wwwandapps.damkalanfinalproject.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wwwandapps.damkalanfinalproject.model.Nbateam;
import com.wwwandapps.damkalanfinalproject.service.NbateamServiceInterface;

@Controller
public class NbateamController {

    private final Logger logger = LoggerFactory.getLogger(NbateamController.class);

    @Autowired
    private NbateamServiceInterface nbateamService;



    @RequestMapping(value = "/nbateams/list", method = RequestMethod.GET)
    public String showAllNbateams(Model model) {

        logger.debug("showAllNbateams()");
        model.addAttribute("nbateams", nbateamService.findAll());
        return "listteams.jsp";

    }


    @RequestMapping(value = "/nbateams/{id}/list", method = RequestMethod.GET)
    public String showNbateamById(@PathVariable("id") Long id,Model model) {

        logger.debug("showNbateamById()");
        model.addAttribute("nbateam", nbateamService.findById(id));
        return "listteam.jsp";
    }


    @RequestMapping(value = "/nbateam", method = RequestMethod.POST)
    public String saveOrUpdateNbateam(@ModelAttribute("nbateamForm") @Validated Nbateam nbateam,
                                   BindingResult result, Model model,
                                   final RedirectAttributes redirectAttributes) {

        logger.debug("saveOrUpdateNbateam() : {}", nbateam);

        if (result.hasErrors()) {
            return "nbateam/nbateamForm";
        } else {

            // Add message to flash scope
            redirectAttributes.addFlashAttribute("css", "success");
            if(nbateam.isNew()){
                redirectAttributes.addFlashAttribute("msg", "User added successfully!");
            }else{
                redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
            }

            nbateamService.saveOrUpdate(nbateam);

            // POST/REDIRECT/GET
            return "redirect:/nbateams/" + nbateam.getId();

            // POST/FORWARD/GET
            // return "user/list";

        }

    }

    // show add user form
    @RequestMapping(value = "/nbateams/add", method = RequestMethod.GET)
    public String showAddNbateamForm(Model model) {

        logger.debug("showAddNbateamForm()");

        Nbateam nbateam = new Nbateam();

        // set default value
        nbateam.setName("name");
        nbateam.setFullname("fullname");
        nbateam.setCity("city");
        nbateam.setConference("conference");
        nbateam.setDivision("division");
        model.addAttribute("nbateamform", nbateam);

        return "nbateams/nbateamform";
    }

    // show update form
    @RequestMapping(value = "/nbateams/{id}/update", method = RequestMethod.GET)
    public String showUpdateNbateamForm(@PathVariable("id") Long id, Model model) {
        logger.debug("showUpdateNbateamForm() : {}", id);
        Nbateam nbateam = nbateamService.findById(id);
        model.addAttribute("nbateamform", nbateam);
        return "nbateams/nbateamform";
    }

    // delete user
    @RequestMapping(value = "/nbateams/{id}/delete", method = RequestMethod.POST)
    public String deleteNbateam(@PathVariable("id") Long id,
                             final RedirectAttributes redirectAttributes) {
        logger.debug("deleteNbateam() : {}", id);
        nbateamService.delete(id);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Nba team is deleted!");
        return "redirect:/users";

    }

    // show user
    @RequestMapping(value = "/nbateams/{id}", method = RequestMethod.GET)
    public String showNbateam(@PathVariable("id") Long id, Model model) {

        logger.debug("showNbateam() id: {}", id);

        Nbateam nbateam = nbateamService.findById(id);
        if (nbateam == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("nbateam", nbateam);

        return "users/show";

    }



}