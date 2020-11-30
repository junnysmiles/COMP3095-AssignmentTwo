/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 2
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 11/07/2020
 * Description: Implements loadUserByUsername from userdetailservice using findByEmail
 * ****************************************************************************************************************/
package ca.gbc.services;

import ca.gbc.model.User;
import ca.gbc.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = repo.findByEmail(s);
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        return new UserDetailsImpl(user);
    }
}
