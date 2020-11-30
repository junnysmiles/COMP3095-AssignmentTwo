/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 2
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 11/07/2020
 * Description: For routing to the main interface
 * ****************************************************************************************************************/
package ca.gbc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
    @RequestMapping({"", "/", "/login"})
    public String index() {
        return "login/index";
    }
}
