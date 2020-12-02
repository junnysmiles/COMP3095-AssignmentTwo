/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 2
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 07/11/2020 -Nick created file
 *       02/12/2020 -Nick added user details for testing
 * Description: Loads default admin as per reqs, also test admin/client details are
 *              admin@admin.com pass        client@client.com pass
 * ****************************************************************************************************************/
package ca.gbc.bootstrap;

import ca.gbc.model.*;
import ca.gbc.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
    public void run(String... args) throws Exception {/*
        Admin user = new Admin();
        user.setFirstName("Nick");
        user.setLastName("Chinsen");
        user.setPassword(passwordEncoder.encode("P@ssword1"));
        //set an address
        user.setCity("Toronto");
        user.setCountry("Canada");
        user.setPostal("M4Y 3C4");
        user.setStreetName("281 Mutual St.");
        //set date of birth
        user.setDay("28");
        user.setMonth("10");
        user.setYear("1995");
        user.setEmail("admin@isp.net");
        user.setAccountCreated(LocalDate.now());
        userRepo.save(user);

        Admin user2 = new Admin();
        user2.setFirstName("Test");
        user2.setLastName("User");
        user2.setPassword(passwordEncoder.encode("pass"));
        //set address
        user2.setStreetName("32 Test St.");
        user2.setCountry("Canada");
        user2.setCity("Toronto");
        user2.setPostal("O3E 3J3");
        //set date of birth
        user2.setDay("28");
        user2.setMonth("10");
        user2.setYear("1995");
        user2.setEmail("admin@admin.com");
        user2.setAccountCreated(LocalDate.now());
        userRepo.save(user2);

        Client user3 = new Client();
        user3.setFirstName("Test");
        user3.setLastName("User");
        user3.setPassword(passwordEncoder.encode("pass"));
        //set address
        user3.setStreetName("32 Test St.");
        user3.setCountry("Canada");
        user3.setCity("Toronto");
        user3.setPostal("O3E 3J3");
        //set date of birth
        user3.setDay("28");
        user3.setMonth("10");
        user3.setYear("1995");
        user3.setEmail("client@client.com");
        user3.setAccountCreated(LocalDate.now());
        userRepo.save(user3);*/
    }
}
