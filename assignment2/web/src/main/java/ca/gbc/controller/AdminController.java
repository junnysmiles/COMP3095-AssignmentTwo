/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 25/11/2020 -Nick Created file
 *       01/12/2020 -Nick Updated request mappings
 *       03/12/2020 -Nick Added functionalities for various mappings
 *       06/12/2020 -Nick Added inbox functionalities
 * Description: Controller for admins that successfully login
 * ****************************************************************************************************************/
package ca.gbc.controller;

import ca.gbc.model.Admin;
import ca.gbc.model.Client;
import ca.gbc.model.Ticket;
import ca.gbc.repositories.AdminRepo;
import ca.gbc.repositories.ClientRepo;
import ca.gbc.repositories.TicketRepo;
import ca.gbc.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class AdminController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    AdminRepo adminRepo;
    @Autowired
    TicketRepo ticketRepo;

    @RequestMapping("/dashboard/adminProfile")
    public String adminProfile(Model model, Authentication authentication) {
        Admin user = adminRepo.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        return "dashboard/admin/profile";
    }

    //updates admin profile
    @RequestMapping(value = "/dashboard/adminProfile", method = RequestMethod.POST)
    public String adminProfileUpdate(Model model, @Valid @ModelAttribute("user") Admin admin, Authentication authentication) {
        Admin updateAdmin = adminRepo.findByEmail(authentication.getName());
        model.addAttribute("user", admin);
        updateAdmin.setFirstName(admin.getFirstName());
        updateAdmin.setLastName(admin.getLastName());
        updateAdmin.setEmail(admin.getEmail());
        updateAdmin.setDay(admin.getDay());
        updateAdmin.setMonth(admin.getMonth());
        updateAdmin.setYear(admin.getYear());
        updateAdmin.setStreetName(admin.getStreetName());
        updateAdmin.setCity(admin.getCity());
        updateAdmin.setCountry(admin.getCountry());
        updateAdmin.setPostal(admin.getPostal());
        userRepo.save(updateAdmin);
        return "dashboard/admin/admin-dash";

    }

    //shows a list of Clients and allows for deletion
    @RequestMapping("/dashboard/adminUsers")
    public String listUsers(Model model, Admin admin, Authentication authentication) {
        Admin currentUser = adminRepo.findByEmail(authentication.getName());
        model.addAttribute("clients", clientRepo.findAll());
        model.addAttribute("user", currentUser);
        System.out.println(model);
        return "dashboard/admin/users";
    }

    //display all tickets
    @RequestMapping("/dashboard/adminInbox")
    public String adminInbox(Model model, Admin admin, Authentication authentication) {
        Admin currentUser = adminRepo.findByEmail(authentication.getName());
        model.addAttribute("tickets", currentUser.getTickets());
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("user", currentUser);
        return "dashboard/admin/inbox";
    }

    //delete ticket
    @RequestMapping("/dashboard/deleteAdminTicket/{id}")
    public String deleteTicket(@PathVariable("id") Long id, Model model, Authentication authentication) {
        Admin user = adminRepo.findByEmail(authentication.getName());
        Ticket ticket = ticketRepo.findById(id).orElse(null);
        user.removeTicket(ticket);
        adminRepo.save(user);
        model.addAttribute("user", user);
        model.addAttribute("tickets", user.getTickets());
        return "dashboard/admin/inbox";
    }

    //read message shows all tickets
    @RequestMapping("/dashboard/adminInboxRead/{id}")
    public String inboxRead(@PathVariable("id") Long id, Model model, Authentication authentication) {
        Admin user = adminRepo.findByEmail(authentication.getName());
        model.addAttribute("tickets", ticketRepo.findTicketsByTicketNumber(id));
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("ticketId", id);
        model.addAttribute("user", user);
        return "dashboard/admin/ticket";
    }

    //reply to support tickets
    @RequestMapping("/dashboard/adminInboxReply/")
    public String adminReply(Model model, Authentication authentication, @Valid Ticket ticket, BindingResult bindingResult){
        Admin user = adminRepo.findByEmail(authentication.getName());
        if(bindingResult.hasErrors()){
            System.out.println("Binding Result Error");
            System.out.println(bindingResult);
            return "dashboard/admin/ticket";
        } else {
            ticket.setEmail(user.getEmail());
            String name = user.getFirstName() + ' ' + user.getLastName();
            ticket.setFirstName(name);
            ticket.setTimeStamp(LocalDateTime.now());
            ticketRepo.save(ticket);
            //set admin ticket
            user.setTicket(ticket);
            adminRepo.save(user);
            //assign back to user
            Ticket clientTicket = ticketRepo.findById(ticket.getId()).orElse(null);
            Client client = clientRepo.findByEmail(clientTicket.getEmail());
            //client.setTicket(ticket);
            clientRepo.save(client);
        }
        model.addAttribute("tickets", ticketRepo.findTicketsByTicketNumber(ticket.getId()));
        model.addAttribute("ticketId", ticket.getId());
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("user", user);
        return "dashboard/admin/ticket";
    }

    //mappping for admin support page
    @RequestMapping("/dashboard/adminSupport")
    public String adminSupport(Model model, Admin admin, Authentication authentication) {
        Admin currentUser = adminRepo.findByEmail(authentication.getName());
        model.addAttribute("admins", adminRepo.findAll());
        model.addAttribute("user", currentUser);
        return "dashboard/admin/support";
    }

    //check if admin exists, if they do update otherwise add
    @RequestMapping(value = "/dashboard/adminSupport", method = RequestMethod.POST)
    public String addAdmin(Model model, @Valid @ModelAttribute("user") Admin admin, Authentication authentication) {
        Admin currentUser = adminRepo.findByEmail(authentication.getName());
        Admin addAdmin = adminRepo.findByEmail(admin.getEmail());
        if(addAdmin == null) {
            adminRepo.save(admin);
        }else{
            addAdmin.setFirstName(admin.getFirstName());
            addAdmin.setLastName(admin.getLastName());
            addAdmin.setEmail(admin.getEmail());
            addAdmin.setDay(admin.getDay());
            addAdmin.setMonth(admin.getMonth());
            addAdmin.setYear(admin.getYear());
            addAdmin.setStreetName(admin.getStreetName());
            addAdmin.setCity(admin.getCity());
            addAdmin.setCountry(admin.getCountry());
            addAdmin.setPostal(admin.getPostal());
            adminRepo.save(addAdmin);
        }
        //add all necessary data to model
        model.addAttribute("admins", adminRepo.findAll());
        model.addAttribute("user", currentUser);
        return "dashboard/admin/support";
    }
}
