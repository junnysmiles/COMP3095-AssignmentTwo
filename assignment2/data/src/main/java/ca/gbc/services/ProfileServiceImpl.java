/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 05/12/2020 -Nick created file
 * Description: Profile service implementation
 * ****************************************************************************************************************/
package ca.gbc.services;

import ca.gbc.model.Client;
import ca.gbc.model.CreditCard;
import ca.gbc.model.Profile;
import ca.gbc.repositories.ProfileRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProfileServiceImpl implements ProfileService{
    private final ProfileRepo profileRepo;

    public ProfileServiceImpl(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    @Override
    public Set<Profile> findAll() {
        Set<Profile> profiles = new HashSet<>();
        profileRepo.findAll().forEach(profiles::add);
        return profiles;
    }
    @Override
    public Profile findById(Long aLong) {
        return profileRepo.findById(aLong).orElse(null);
    }

    @Override
    public Profile save(Profile object) {
        return profileRepo.save(object);
    }

    @Override
    public void delete(Profile object) {
        profileRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        profileRepo.deleteById(aLong);
    }
}
