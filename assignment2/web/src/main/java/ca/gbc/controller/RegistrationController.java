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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @RequestMapping("")
    public String display() {
        return "registration/index";
    }
    @RequestMapping(params = "register", method = RequestMethod.POST)
    public String register(Model model, HttpServletResponse response) {
        System.out.println(response.toString());
        model.addAttribute("message", "Registration Successful check your email");
        return "registration/success";
    }

    @RequestMapping(params = "reset", method = RequestMethod.POST)
    public String cancel() {
        return "registration/index";
    }

}
