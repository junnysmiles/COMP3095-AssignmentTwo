package ca.gbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {
    @RequestMapping("/dashboard/credit")
    public String creditProfile() {
        return "dashboard/client/credit";
    }
}
