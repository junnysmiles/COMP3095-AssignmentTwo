/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 2
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 11/07/2020
 * Description: Data Loader to put in initial admin user into database
 * ****************************************************************************************************************/
package ca.gbc.bootstrap;

import ca.gbc.model.Address;
import ca.gbc.model.Role;
import ca.gbc.model.User;
import ca.gbc.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    //private final ClientService clientService;
    private final UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public DataLoader(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        Address address = new Address();
        user.setFirstName("Nick");
        user.setLastName("Chinsen");
        user.setPassword(passwordEncoder.encode("P@ssword1"));
        //set an address
        address.setCity("Toronto");
        address.setCountry("Canada");
        address.setPostal("M4Y 3C4");
        address.setStreetName("281 Mutual St.");
        user.setAddress(address);
        user.setEmail("admin@isp.net");
        user.setRole(Role.ADMIN);
        userRepo.save(user);

        User user2 = new User();
        Address address1 = new Address();
        user2.setFirstName("Test");
        user2.setLastName("User");
        user2.setPassword(passwordEncoder.encode("pass"));
        //set address
        address1.setStreetName("32 Test St.");
        address1.setCountry("Canada");
        address1.setCity("Toronto");
        address1.setPostal("O3E 3J3");
        user2.setAddress(address1);
        user2.setEmail("user@gmail.com");
        user2.setRole(Role.ADMIN);
        userRepo.save(user2);
    }
}
