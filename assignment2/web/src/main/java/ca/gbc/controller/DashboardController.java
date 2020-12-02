/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 07/11/2020 -Nick Created file
 *       02/12/2020 -Nick Updated comments for assignment 3
 * Description: Dashboard controller redirects to client/admin controller depending on
 *              role type
 * ****************************************************************************************************************/
package ca.gbc.controller;

import ca.gbc.model.Admin;
import ca.gbc.model.User;
import ca.gbc.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping({"", "/"})
    public String dashboard(Model model, Authentication authentication) {
        //find user details by email
        User user = userRepo.findByEmail(authentication.getName());
        //set last login timestamp
        user.setLastLogin(LocalDate.now());
        model.addAttribute("user", user);
        //redirect based on admin or client
        if(user instanceof Admin){
            return "dashboard/admin/admin-dash";
        }
        return "dashboard/client/client-dash";
    }
}
