/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 28/11/2020 -Nick Created file
 *       30/11/2020 -Nick Updated request mappings
 *       02/12/2020 -Nick Modified credit profile mappings
 *       05/12/2020 -Nick Modified profile addition mapping
 * Description: Controller for Clients after they successfully login
 * ****************************************************************************************************************/
package ca.gbc.controller;

import ca.gbc.model.*;
import ca.gbc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ClientController {

    @Autowired
    UserRepo userRepo;
    @Autowired
    CreditCardRepo cardRepo;
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    TicketRepo ticketRepo;
    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    AdminRepo adminRepo;

    @RequestMapping("/dashboard/clientProfile")
    public String clientProfile(Model model, Authentication authentication) {
        Client user = clientRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        model.addAttribute("profile", new Profile());
        model.addAttribute("profiles", profileRepo.findAll());
        return "dashboard/client/profile";
    }

    //update client information
    @RequestMapping("/dashboard/clientUpdate")
    public String clientInfoUpdate(Model model, Authentication authentication, Client client, BindingResult bindingResult){
        Client user = clientRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        if(bindingResult.hasErrors()){
            System.out.println("BINDING ERROR");
            System.out.println(bindingResult);
            return "dashboard/client/profile";
        }else {
            user.setFirstName(client.getFirstName());
            user.setLastName(client.getLastName());
            user.setDay(client.getDay());
            user.setMonth(client.getMonth());
            user.setYear(client.getYear());
            user.setLastUpdate(LocalDateTime.now());
            userRepo.save(user);
        }
        model.addAttribute("user", clientRepo.findByEmail(authentication.getName()));
        model.addAttribute("profile", new Profile());
        model.addAttribute("profiles", profileRepo.findAll());
        return "dashboard/client/profile";
    }

    //create/update profile
    @RequestMapping(value = "/dashboard/clientProfile", method = RequestMethod.POST)
    public String clientProfileAdd(Model model, Authentication authentication, @Valid Profile profile, BindingResult bindingResult) {
        Client user = clientRepo.findByEmail(authentication.getName());
        if(bindingResult.hasErrors()){
            System.out.println("BINDING ERROR");
            return "dashboard/client/profile";
        } else {//add new profile
            profile.setClient(user);
            profileRepo.save(profile);
        }
        model.addAttribute("user", user);
        model.addAttribute("profile", profile);
        model.addAttribute("profiles", profileRepo.findAll());
        return "dashboard/client/profile";
    }


    //delete profile
    @RequestMapping("/dashboard/deleteClient/{id}")
    public String deleteProfile(@PathVariable("id") Long id, Model model, Authentication authentication){
        profileRepo.deleteById(id);
        Client user = clientRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        model.addAttribute("profile", new Profile());
        model.addAttribute("profiles", profileRepo.findAll());
        return "dashboard/client/profile";
    }

    //delete credit card
    @RequestMapping("/dashboard/deleteCard/{id}")
    public String deleteCredit(@PathVariable("id") Long id, Model model, Authentication authentication){
        cardRepo.deleteById(id);
        Client user = clientRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        model.addAttribute("profile", new Profile());
        model.addAttribute("profiles", profileRepo.findAll());
        return "dashboard/client/credit";
    }

    //mapping for credit profile page
    @RequestMapping("/dashboard/clientCredit")
    public String clientCredit(Model model, Authentication authentication) {
        Client user = clientRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        model.addAttribute("card", new CreditCard());
        model.addAttribute("cards", cardRepo.findAll());
        return "dashboard/client/credit";
    }

    //add/update a new credit card
    @RequestMapping(value = "/dashboard/clientCredit", method = RequestMethod.POST)
    public String addCreditCard(Model model, Authentication authentication, @Valid CreditCard creditCard,BindingResult bindingResult) {
        Client user = clientRepo.findByEmail(authentication.getName());
        //reroute back to registration if any errors
        if(bindingResult.hasErrors()) {
            System.out.println("BINDING RESULT ERROR");
        } else { //create new client
            //check if card exists

            CreditCard creditCard1 = cardRepo.findCCByNumber(creditCard.getCCNumber());
            if(creditCard1 == null) {
                creditCard.setClient(user);
                cardRepo.save(creditCard);
            }else {//card exists so update values
                creditCard1.setCardholderName(creditCard.getCardholderName());
                creditCard1.setCCNumber(creditCard.getCCNumber());
                creditCard1.setClient(user);
                creditCard1.setDefaultCC(true);
                creditCard1.setExpirationMonth(creditCard.getExpirationMonth());
                creditCard1.setExpirationYear(creditCard.getExpirationMonth());
                creditCard1.setCardType(creditCard.getCardType());
                cardRepo.save(creditCard1);
            }
        }
        model.addAttribute("card", creditCard);
        model.addAttribute("cards", cardRepo.findAll());
        model.addAttribute("user", user);
        return "dashboard/client/credit";
    }

    //inbox mapping
    @RequestMapping("/dashboard/clientInbox")
    public String clientInbox(Model model, Authentication authentication) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("tickets", user.getTickets());
        model.addAttribute("user", user);
        return "dashboard/client/inbox";
    }

    //support page mapping
    @RequestMapping("/dashboard/clientSupport")
    public String clientSupport(Model model, Authentication authentication) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        model.addAttribute("ticket", new Ticket());
        return "dashboard/client/support";
    }

    //mapping for when a client sends a support ticket
    @RequestMapping(value = "/dashboard/clientSupport", method = RequestMethod.POST)
    public String sendSupport(Model model, Authentication authentication, @Valid Ticket ticket, BindingResult bindingResult) {
        Client user = clientRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        if(bindingResult.hasErrors()){
            System.out.println("BINDING RESULT ERROR");
            return "dashboard/client/support";
        } else {//save ticket
            ticket.setEmail(user.getEmail());
            String name = user.getFirstName() + ' ' + user.getLastName();
            ticket.setFirstName(name);
            ticket.setTimeStamp(LocalDateTime.now());
            ticketRepo.save(ticket);
            //save to client inbox
            ticket.setTicketNumber(ticket.getId());
            ticketRepo.save(ticket);
            user.setTicket(ticket);
            clientRepo.save(user);
            //assign to admin and save
            Admin admin = adminRepo.findByEmail("admin@isp.net");
            admin.setTicket(ticket);
            adminRepo.save(admin);
            //reset ticket model
            model.addAttribute("ticket", new Ticket());
            return "dashboard/client/support";
        }
    }
}
