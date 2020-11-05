package ca.gbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dashboard")
@Controller
public class DashboardController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String dashboard() { return "dashboard/index"; }
}
