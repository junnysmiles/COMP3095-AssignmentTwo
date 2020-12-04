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

    @Override
    public Ticket findById(Long aLong) {
        return ticketRepo.findById(aLong).orElse(null);
    }

    @Override
    public Ticket save(Ticket object) {
        return ticketRepo.save(object);
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
