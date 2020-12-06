/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 29/11/2020 -Nick created file
 * Description: Client entity which extends user can have many CCs and profiles
 * ****************************************************************************************************************/
package ca.gbc.model;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQuery(name = "Client.findAllClients",
  query = "select c from User c where c is not null")
public class Client extends User{
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<CreditCard> creditCards;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<Profile> profiles;
    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Set<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Profile> profiles) {
        this.profiles = profiles;
    }


}
