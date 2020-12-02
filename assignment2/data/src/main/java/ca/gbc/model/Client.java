/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 02/12/2020
 * Description: Client entity which extends user can have many CCs and profiles
 * ****************************************************************************************************************/
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
