/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 2
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 11/07/2020
 * Description: Role model has 1 to 1 relationship with User
 * ****************************************************************************************************************/
package ca.gbc.model;
import javax.persistence.*;

@Entity
public class Role {
    private Long id;
    private String name;
    private User user;

    public Role(String name){
        this.name = name;
    }

    public Role() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(mappedBy = "roles")
    public User getUsers() {
        return user;
    }

    public void setUsers(User users) {
        this.user = users;
    }
}
