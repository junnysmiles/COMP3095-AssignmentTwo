/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 05/12/2020 -Nick created file
 *       06/12/2020 -Nick added findByTicketNumber function
 * Description: Ticket Service Implementation
 * ****************************************************************************************************************/
package ca.gbc.services;

import ca.gbc.model.Ticket;
import ca.gbc.repositories.TicketRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TicketServiceImpl implements TicketService{
    private final TicketRepo ticketRepo;

    public TicketServiceImpl(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @Override
    public Set<Ticket> findAll() {
        Set<Ticket> tickets = new HashSet<>();
        ticketRepo.findAll().forEach(tickets::add);
        return tickets;
    }

    public Set<Ticket> findByTicketNumber(Long aLong) {
        Set<Ticket> tickets = new HashSet<>();
        ticketRepo.findTicketsByTicketNumber(aLong);
        return tickets;
    }

    @Override
    public Ticket findById(Long aLong) {
        return ticketRepo.findById(aLong).orElse(null);
    }

    @Override
    public Ticket save(Ticket object) {
        return ticketRepo.save(object);
    }

    public void deleteTicketByTicketNumber(Long aLong){
        ticketRepo.deleteTicketByTicketNumber(aLong);
    }
    @Override
    public void delete(Ticket object) {
        ticketRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ticketRepo.deleteById(aLong);
    }
}
