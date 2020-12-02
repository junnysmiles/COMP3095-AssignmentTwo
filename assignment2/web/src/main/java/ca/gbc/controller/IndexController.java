/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 07/11/2020 -Nick Created File
 *       27/11/2020 -Nick Removed redundant paths
 * Description: Initial Controller for application
 * ****************************************************************************************************************/
package ca.gbc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
    @RequestMapping({"", "/", "/login"})
    public String index() {
        return "login/index";
    }
}
