/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 28/11/2020 -Nick created file
 * Description: Profile entity which has values to let the system know if it's the default
 *              shipping/billing address
 * ****************************************************************************************************************/
package ca.gbc.model;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Profile extends User{
    @ManyToOne
    private Client client;
    private Boolean defaultBilling;
    private Boolean defaultShipping;
}
