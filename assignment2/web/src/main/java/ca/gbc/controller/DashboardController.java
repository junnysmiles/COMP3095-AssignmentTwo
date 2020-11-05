package ca.gbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String dashboard() { return "dashboard/index"; }
}
