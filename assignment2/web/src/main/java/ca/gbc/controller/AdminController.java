package ca.gbc.controller;

import ca.gbc.model.User;
import ca.gbc.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class AdminController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping("/dashboard/adminProfile")
    public String adminProfile(Model model, Authentication authentication) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        return "dashboard/admin/profile";
    }

    @RequestMapping("/dashboard/adminUsers")
    public String adminUsers(Model model, Authentication authentication) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        return "dashboard/admin/users";
    }

    @RequestMapping("/dashboard/adminInbox")
    public String adminInbox(Model model, Authentication authentication) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        return "dashboard/admin/inbox";
    }

    @RequestMapping("/dashboard/adminSupport")
    public String adminSupport(Model model, Authentication authentication) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        return "dashboard/admin/support";
    }
}
