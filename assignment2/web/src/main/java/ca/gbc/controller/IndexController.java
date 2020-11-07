package ca.gbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/login")
@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index" ,"/index.html"})
    public String index() { return "login/index"; }
}
