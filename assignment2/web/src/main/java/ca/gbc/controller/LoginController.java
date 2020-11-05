package ca.gbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String login() { return "login/index"; }
}
