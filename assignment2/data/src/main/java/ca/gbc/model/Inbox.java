/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 29/11/2020 -Nick created file
 * Description: Inbox which has many-to-many with tickets and one-to-one with user
 * ****************************************************************************************************************/
package ca.gbc.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Inbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private Set<Ticket> readTickets;
    @ManyToMany
    private Set<Ticket> unreadTickets;
    @OneToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Ticket> getReadTickets() {
        return readTickets;
    }

    public void setReadTickets(Set<Ticket> readTickets) {
        this.readTickets = readTickets;
    }

    public Set<Ticket> getUnreadTickets() {
        return unreadTickets;
    }

    public void setUnreadTickets(Set<Ticket> unreadTickets) {
        this.unreadTickets = unreadTickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
