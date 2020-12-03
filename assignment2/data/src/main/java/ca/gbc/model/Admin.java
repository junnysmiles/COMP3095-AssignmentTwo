/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 28/11/2020 -Nick created file
 * Description: Admin inherits from User
 * ****************************************************************************************************************/
package ca.gbc.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Admin.findAllAdmins",
        query = "select a from Admin a where a is not null")
public class Admin extends User{
}
