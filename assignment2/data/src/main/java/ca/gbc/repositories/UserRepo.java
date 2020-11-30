/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 2
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 11/07/2020
 * Description: User Repo extending JpaRepository for operations on H2 database
 *              Also contains findByEmail to be implemented
 * ****************************************************************************************************************/
package ca.gbc.repositories;

import ca.gbc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
