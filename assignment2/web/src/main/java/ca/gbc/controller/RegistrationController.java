/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 07/11/2020 -Nick Created file
 *       29/11/2020 -Nick Modified registration to include new DOB and address
 * Description: Saves new user and redirects to a success page
 * ****************************************************************************************************************/
package ca.gbc.controller;

import ca.gbc.email.EmailConfig;
import ca.gbc.model.Role;
import ca.gbc.model.User;
import ca.gbc.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private EmailConfig emailConfig;

    public RegistrationController(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    @RequestMapping({"", "/index", "/index.html"})
    public String display(Model model) {
        model.addAttribute("user", new User());
        return "registration/index";
    }
    @RequestMapping(params = "register", method = RequestMethod.POST)
    public String register(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        //reroute back to registration if any errors
        if(bindingResult.hasErrors()) {
            System.out.println("BINDING RESULT ERROR");
            return "registration/index";
        } else { //create new client
            user.setRole(Role.CLIENT);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            model.addAttribute("user", user);
            userRepo.save(user);

            //create email sender
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost(this.emailConfig.getHost());
            mailSender.setPort(this.emailConfig.getPort());
            mailSender.setUsername(this.emailConfig.getUsername());
            mailSender.setPassword(this.emailConfig.getPassword());

            //create instance for email
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom("fa47894c16-faab47@inbox.mailtrap.io");
            mail.setTo(user.getEmail());
            mail.setSubject("Thanks for registering on our business website");
            mail.setText("Hi " + user.getFirstName() + " " + user.getLastName() + "<br>" +
                    user.getEmail() + "<br>" + " Login now: " + "http://localhost:8081/login");

            //send email
            mailSender.send(mail);
            //return success page
            return "registration/success";
        }
    }

}
