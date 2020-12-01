/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 2
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 11/07/2020
 * Description: Data Loader to put in initial admin user into database
 * ****************************************************************************************************************/
package ca.gbc.bootstrap;

import ca.gbc.model.*;
import ca.gbc.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
        Dob dob = new Dob();
        user.setFirstName("Nick");
        user.setLastName("Chinsen");
        user.setPassword(passwordEncoder.encode("P@ssword1"));
        //set an address
        address.setCity("Toronto");
        address.setCountry("Canada");
        address.setPostal("M4Y 3C4");
        address.setStreetName("281 Mutual St.");
        user.setAddress(address);
        //set date of birth
        dob.setDay(28);
        dob.setMonth(10);
        dob.setYear(1995);
        user.setDob(dob);
        user.setEmail("admin@isp.net");
        user.setAccountCreated(LocalDate.now());
        user.setRole(Role.ADMIN);
        userRepo.save(user);

        User user2 = new User();
        Address address1 = new Address();
        Dob dob2 = new Dob();
        user2.setFirstName("Test");
        user2.setLastName("User");
        user2.setPassword(passwordEncoder.encode("pass"));
        //set address
        address1.setStreetName("32 Test St.");
        address1.setCountry("Canada");
        address1.setCity("Toronto");
        address1.setPostal("O3E 3J3");
        user2.setAddress(address1);
        //set date of birth
        dob2.setDay(28);
        dob2.setMonth(10);
        dob2.setYear(1995);
        user2.setDob(dob2);
        user2.setEmail("admin@admin.com");
        user2.setAccountCreated(LocalDate.now());
        user2.setRole(Role.ADMIN);
        userRepo.save(user2);

        User user3 = new User();
        Address address2 = new Address();
        Dob dob3 = new Dob();
        user3.setFirstName("Test");
        user3.setLastName("User");
        user3.setPassword(passwordEncoder.encode("pass"));
        //set address
        address2.setStreetName("32 Test St.");
        address2.setCountry("Canada");
        address2.setCity("Toronto");
        address2.setPostal("O3E 3J3");
        user3.setAddress(address2);
        //set date of birth
        dob3.setDay(28);
        dob3.setMonth(10);
        dob3.setYear(1995);
        user3.setDob(dob3);
        user3.setEmail("client@client.com");
        user3.setAccountCreated(LocalDate.now());
        user3.setRole(Role.CLIENT);
        userRepo.save(user3);
    }
}
