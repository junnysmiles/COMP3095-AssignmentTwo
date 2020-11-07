/*********************************************************************************
* Project: Business Dash
 * Assignment: Assignment 2
 * Author(s): Nicholas Chinsen
 * Student Number: 101075596
 * Date: November 6th 2020
 * Description: Controller for registration, checks if user is registered already
 *              if not registers them.
 *********************************************************************************/
package ca.gbc.controller;

import ca.gbc.model.Client;
import ca.gbc.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private ClientService clientRepo;

    @RequestMapping({"", "/index", "/index.html"})
    public String display(Model model) {
        model.addAttribute("client", new Client());
        return "registration/index";
    }
    @RequestMapping(params = "register", method = RequestMethod.POST)
    public String register(Model model, Client client) {
        client.setRoleType("CLIENT");
        model.addAttribute("client", client);
        clientRepo.save(client);


        return "registration/success";
    }

}
