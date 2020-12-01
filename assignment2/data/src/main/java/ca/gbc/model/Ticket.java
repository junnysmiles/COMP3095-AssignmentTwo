package ca.gbc.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String email;
    private String subject;
    private LocalDate timeStamp;

    @OneToOne(cascade = CascadeType.ALL)
    private TicketNumber ticketNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public TicketNumber getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(TicketNumber ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
