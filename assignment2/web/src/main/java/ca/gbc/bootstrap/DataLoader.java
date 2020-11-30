/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 2
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 11/07/2020
 * Description: Data Loader to put in initial admin user into database
 * ****************************************************************************************************************/
package ca.gbc.bootstrap;

import ca.gbc.model.Role;
import ca.gbc.model.User;
import ca.gbc.repositories.RoleRepo;
import ca.gbc.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    //private final ClientService clientService;
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public DataLoader(UserRepo userRepo, RoleRepo roleRepo){
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Role role = new Role();
        User user = new User("admin@isp.net", "Nick", "Chinsen",
                "test address", passwordEncoder.encode("P@ssword1") );
        role.setName("ADMIN");
        roleRepo.save(role);
        user.setRoles(role);
        userRepo.save(user);
    }
}
