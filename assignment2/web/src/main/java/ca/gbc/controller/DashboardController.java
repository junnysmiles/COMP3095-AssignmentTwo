package ca.gbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String dashboard() { return "dashboard/index"; }

    @RequestMapping({"/futureExtension1", "/futureExtension1.html"})
    public String futureExtension1() { return "dashboard/futureExtension1"; }

    @RequestMapping({"/futureExtension2", "/futureExtension2.html"})
    public String futureExtension2() { return "dashboard/futureExtension2"; }

    @RequestMapping({"/futureExtension3", "/futureExtension3.html"})
    public String futureExtension3() { return "dashboard/futureExtension3"; }

    @RequestMapping({"/futureExtension4", "futureExtension4.html"})
    public String futureExtension4() { return "dashboard/futureExtension4"; }
}
