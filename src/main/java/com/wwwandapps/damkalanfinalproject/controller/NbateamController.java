package com.wwwandapps.damkalanfinalproject.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    // delete team
    @RequestMapping(value = "/nbateams/{id}/delete", method = RequestMethod.GET)
    public String deleteNbateam(@PathVariable("id") Long id,Model model)  {
        logger.debug("deleteNbateam() " );
        nbateamService.delete(id);
        return "redirect:/nbateams/list";
    }

}