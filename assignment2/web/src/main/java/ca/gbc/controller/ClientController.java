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
import ca.gbc.repositories.ClientRepo;
import ca.gbc.repositories.CreditCardRepo;
import ca.gbc.repositories.TicketRepo;
import ca.gbc.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.LocalDate;

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

    @RequestMapping("/dashboard/clientProfile")
    public String clientProfile(Model model, Authentication authentication) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        return "dashboard/client/profile";
    }

    @RequestMapping(value = "/dashboard/clientProfileAdd", params = "action=add")
    public String clientProfileAdd(Model model, Authentication authentication, @Valid Profile profile, BindingResult bindingResult) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        if(bindingResult.hasErrors()){
            System.out.println("BINDING ERROR");
            return "dashboard/client/profile";
        } else {
        }
        return "dashboard/client/profile";
    }

    @RequestMapping(value = "/dashboard/clientProfileAdd", params = "action=update")
    public String clientProfileUpdate(Model model, Authentication authentication, @Valid Profile profile, BindingResult bindingResult) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        if(bindingResult.hasErrors()){
            System.out.println("BINDING ERROR");
            return "dashboard/client/profile";
        } else {

        }
        return "dashboard/client/profile";
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

    @RequestMapping("/dashboard/clientInbox")
    public String clientInbox(Model model, Authentication authentication) {
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        return "dashboard/client/inbox";
    }

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
        User user = userRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        if(bindingResult.hasErrors()){
            System.out.println("BINDING RESULT ERROR");
            return "dashboard/client/support";
        } else {
            ticket.setEmail(user.getEmail());
            String name = user.getFirstName() + ' ' + user.getLastName();
            ticket.setFirstName(name);
            ticket.setTimeStamp(LocalDate.now());
            ticketRepo.save(ticket);
            //reset ticket model
            model.addAttribute("ticket", new Ticket());
            return "dashboard/client/support";
        }
    }
}
