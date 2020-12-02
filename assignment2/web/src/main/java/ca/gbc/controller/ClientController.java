/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 28/11/2020 -Nick Created file
 *       30/11/2020 -Nick Updated request mappings
 * Description: Controller for Clients after they successfully login
 * ****************************************************************************************************************/
package ca.gbc.controller;

import ca.gbc.model.User;
import ca.gbc.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping("/dashboard/clientProfile")
    public String clientProfile(Model model, Authentication authentication) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        return "dashboard/client/profile";
    }

    @RequestMapping("/dashboard/clientCredit")
    public String clientCredit(Model model, Authentication authentication) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        return "dashboard/client/credit";
    }

    @RequestMapping("/dashboard/clientInbox")
    public String clientInbox(Model model, Authentication authentication) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        return "dashboard/client/inbox";
    }

    @RequestMapping("/dashboard/clientSupport")
    public String clientSupport(Model model, Authentication authentication) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        return "dashboard/client/support";
    }
}
