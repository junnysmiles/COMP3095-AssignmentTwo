/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 05/12/2020 -Nick created file
 *       06/12/2020 -Nick Added findTicketsByTicketNumber
 * Description: Repository for Tickets allows for finding tickets by ticket number
 * ****************************************************************************************************************/
package ca.gbc.repositories;

import ca.gbc.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {
    @Query("select p from Ticket p where p.ticketNumber = :ticketNumber")
    Set<Ticket> findTicketsByTicketNumber(@Param("ticketNumber") Long ticketNumber);

    @Query("select p from Ticket p where p.ticketNumber = :ticketNumber")
    void deleteTicketByTicketNumber(@Param("ticketNumber") Long ticketNumber);
}
