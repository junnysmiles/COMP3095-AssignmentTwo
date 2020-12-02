package ca.gbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {
    @RequestMapping("/dashboard/clientProfile")
    public String clientProfile() {
        return "dashboard/client/profile";
    }

    @RequestMapping("/dashboard/creditProfile")
    public String creditProfile() {
        return "dashboard/client/credit";
    }

    @RequestMapping("/dashboard/clientInbox")
    public String clientInbox() {
        return "dashboard/client/inbox";
    }

    @RequestMapping("/dashboard/clientSupport")
    public String clientSupport() {
        return "dashboard/client/support";
    }
}
