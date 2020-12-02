/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 07/11/2020 -Nick Created file
 *       27/11/2020 -Nick Updated loadUserByUsername method
 * Description: Implements loadUserByUsername from userdetailservice using findByEmail
 * ****************************************************************************************************************/
package ca.gbc.services;

import ca.gbc.model.User;
import ca.gbc.repositories.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailsService implements UserDetailsService {

    private final UserRepo repo;

    public UsersDetailsService(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = repo.findByEmail(s);
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        return new UserDetailsImpl(user);
    }
}
