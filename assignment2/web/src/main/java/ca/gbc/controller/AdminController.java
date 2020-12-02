package ca.gbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/dashboard/adminProfile")
    public String adminProfile() {
        return "dashboard/admin/profile";
    }

    @RequestMapping("/dashboard/adminUsers")
    public String adminUsers() {
        return "dashboard/admin/users";
    }

    @RequestMapping("/dashboard/adminInbox")
    public String adminInbox() {
        return "dashboard/admin/inbox";
    }

    @RequestMapping("/dashboard/adminSupport")
    public String adminSupport() {
        return "dashboard/admin/support";
    }
}
