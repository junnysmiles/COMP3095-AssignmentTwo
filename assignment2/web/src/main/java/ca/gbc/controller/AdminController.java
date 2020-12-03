/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 25/11/2020 -Nick Created file
 *       01/12/2020 -Nick Updated request mappings
 *       03/12/2020 -Nick Added functionalities for various mappings
 * Description: Controller for admins that successfully login
 * ****************************************************************************************************************/
package ca.gbc.controller;

import ca.gbc.model.Admin;
import ca.gbc.model.Client;
import ca.gbc.model.User;
import ca.gbc.repositories.AdminRepo;
import ca.gbc.repositories.ClientRepo;
import ca.gbc.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AdminController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    AdminRepo adminRepo;

    @RequestMapping("/dashboard/adminProfile")
    public String adminProfile(Model model, Authentication authentication) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        return "dashboard/admin/profile";
    }

    //updates admin profile
    @RequestMapping(value = "/dashboard/adminProfile", method = RequestMethod.POST)
    public String adminProfileUpdate(Model model, @Valid @ModelAttribute("user") Admin admin, Authentication authentication) {
        User updateAdmin = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", admin);
        updateAdmin.setFirstName(admin.getFirstName());
        updateAdmin.setLastName(admin.getLastName());
        updateAdmin.setEmail(admin.getEmail());
        updateAdmin.setDay(admin.getDay());
        updateAdmin.setMonth(admin.getMonth());
        updateAdmin.setYear(admin.getYear());
        updateAdmin.setStreetName(admin.getStreetName());
        updateAdmin.setCity(admin.getCity());
        updateAdmin.setCountry(admin.getCountry());
        updateAdmin.setPostal(admin.getPostal());
        System.out.println(updateAdmin.getFirstName());
        userRepo.save(updateAdmin);
        return "dashboard/admin/admin-dash";

    }

    //shows a list of Clients and allows for deletion
    @RequestMapping("/dashboard/adminUsers")
    public String listUsers(Model model, Admin admin, Authentication authentication) {
        User currentUser = userRepo.findByEmail(authentication.getName());
        model.addAttribute("clients", clientRepo.findAll());
        model.addAttribute("user", currentUser);
        System.out.println(model);
        return "dashboard/admin/users";
    }

    @RequestMapping("/dashboard/adminInbox")
    public String adminInbox(Model model, Admin admin, Authentication authentication) {
        User currentUser = adminRepo.findByEmail(authentication.getName());
        model.addAttribute("user", currentUser);
        return "dashboard/admin/inbox";
    }

    @RequestMapping("/dashboard/adminSupport")
    public String adminSupport(Model model, Admin admin, Authentication authentication) {
        User currentUser = adminRepo.findByEmail(authentication.getName());
        model.addAttribute("admins", adminRepo.findAll());
        model.addAttribute("user", currentUser);
        return "dashboard/admin/support";
    }

    //check if admin exists, if they do update otherwise add
    @RequestMapping(value = "/dashboard/adminSupport", method = RequestMethod.POST)
    public String addAdmin(Model model, @Valid @ModelAttribute("user") Admin admin, Authentication authentication) {
        User currentUser = adminRepo.findByEmail(authentication.getName());
        User addAdmin = adminRepo.findByEmail(admin.getEmail());
        if(addAdmin == null) {
            adminRepo.save(admin);
        }else{
            addAdmin.setFirstName(admin.getFirstName());
            addAdmin.setLastName(admin.getLastName());
            addAdmin.setEmail(admin.getEmail());
            addAdmin.setDay(admin.getDay());
            addAdmin.setMonth(admin.getMonth());
            addAdmin.setYear(admin.getYear());
            addAdmin.setStreetName(admin.getStreetName());
            addAdmin.setCity(admin.getCity());
            addAdmin.setCountry(admin.getCountry());
            addAdmin.setPostal(admin.getPostal());
            userRepo.save(addAdmin);
        }
        //add all necessary data to model
        model.addAttribute("admins", adminRepo.findAll());
        model.addAttribute("user", currentUser);
        return "dashboard/admin/support";
    }
}
