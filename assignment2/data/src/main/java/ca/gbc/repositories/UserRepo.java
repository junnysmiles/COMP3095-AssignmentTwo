/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 07/11/2020 -Nick created file
 *       02/12/2020 -Nick Updated for new model
 * Description: User Repo extending JpaRepository for operations on H2 database
 *              Also contains findByEmail to be implemented
 * ****************************************************************************************************************/
package ca.gbc.repositories;

import ca.gbc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
