package ca.gbc.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Profile extends User{
    @ManyToOne
    private Client client;
    private Boolean defaultBilling;
    private Boolean defaultShipping;
}
