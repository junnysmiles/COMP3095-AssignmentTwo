/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 03/12/2020 -Nick created file
 * Description: Repo for working with Credit Cards
 * ****************************************************************************************************************/
package ca.gbc.repositories;

import ca.gbc.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CreditCardRepo extends JpaRepository<CreditCard, Long> {

    @Query("select c from CreditCard c where c.CCNumber = :CCNumber")
    CreditCard findCCByNumber(@Param("CCNumber") Long CCNumber);
}
