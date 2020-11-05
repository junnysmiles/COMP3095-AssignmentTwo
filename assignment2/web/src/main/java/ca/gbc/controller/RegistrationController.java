package ca.gbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/registration")
@Controller
public class RegistrationController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String registration() { return "registration/index"; }

}
