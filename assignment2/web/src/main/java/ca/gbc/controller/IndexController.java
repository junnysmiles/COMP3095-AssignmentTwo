package ca.gbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index" ,"/index.html"})
    public String index() { return "login/index"; }

    @RequestMapping(value = "/redirect",params = "register", method = RequestMethod.POST)
    public String register() {
        return "registration/index";
    }

    @RequestMapping(value = "/redirect",params = "login", method = RequestMethod.POST)
    public String dashboard() {
        return "dashboard/index";
    }
}
