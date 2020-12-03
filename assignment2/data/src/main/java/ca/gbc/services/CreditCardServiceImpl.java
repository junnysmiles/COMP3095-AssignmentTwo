/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 03/12/2020 -Nick created file
 * Description: CC service implementation
 * ****************************************************************************************************************/
package ca.gbc.services;

import ca.gbc.model.CreditCard;
import ca.gbc.repositories.CreditCardRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CreditCardServiceImpl implements CreditCardService{
    private final CreditCardRepo creditCardRepo;

    public CreditCardServiceImpl(CreditCardRepo creditCardRepo) {
        this.creditCardRepo = creditCardRepo;
    }

    @Override
    public Set<CreditCard> findAll() {
        Set<CreditCard> creditCards = new HashSet<>();
        creditCardRepo.findAll().forEach(creditCards::add);
        return creditCards;
    }

    public CreditCard findCCByNumber(Long aLong) {
        return creditCardRepo.findCCByNumber(aLong);
    }
    @Override
    public CreditCard findById(Long aLong) {
        return creditCardRepo.findById(aLong).orElse(null);
    }

    @Override
    public CreditCard save(CreditCard object) {
        return creditCardRepo.save(object);
    }

    @Override
    public void delete(CreditCard object) {
        creditCardRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        creditCardRepo.deleteById(aLong);
    }
}
