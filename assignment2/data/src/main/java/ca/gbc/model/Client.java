package ca.gbc.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Client extends User{
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<CreditCard> creditCards;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<Profile> profiles;
}
