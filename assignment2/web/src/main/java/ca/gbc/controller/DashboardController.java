/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 2
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 11/07/2020
 * Description: Dashboard controller including future extensions
 * ****************************************************************************************************************/
package ca.gbc.controller;

import ca.gbc.model.Role;
import ca.gbc.model.User;
import ca.gbc.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping({"", "/"})
    public String dashboard(Model model, Authentication authentication) {
        //find user details by email
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("name", user.getFirstName());
        //redirect based on admin or client
        if(user.getRole() == Role.ADMIN){
            return "dashboard/admin/admin-dash";
        }
        return "dashboard/client/client-dash";
    }

    @RequestMapping({"/adminDashboard"})
    public String adminDashboard(){
        return "dashboard/admin";
    }

    @RequestMapping({"/futureExtension2", "/futureExtension2.html"})
    public String futureExtension2(Model model, Authentication authentication) {
        //find user details by email
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("name", user.getFirstName());
        return "dashboard/futureExtension2";
    }

    @RequestMapping({"/futureExtension3", "/futureExtension3.html"})
    public String futureExtension3(Model model, Authentication authentication) {
        //find user details by email
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("name", user.getFirstName());
        return "dashboard/futureExtension3";
    }

    @RequestMapping({"/futureExtension4", "futureExtension4.html"})
    public String futureExtension4(Model model, Authentication authentication) {
        //find user details by email
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("name", user.getFirstName());
        return "dashboard/futureExtension4";
    }
}
