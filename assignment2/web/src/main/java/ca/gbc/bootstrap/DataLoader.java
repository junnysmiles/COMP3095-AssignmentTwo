package ca.gbc.bootstrap;

import ca.gbc.model.Admin;
import ca.gbc.services.AdminService;
import ca.gbc.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AdminService adminService;
    private final ClientService clientService;

    public DataLoader(AdminService adminService, ClientService clientService){
        this.adminService = adminService;
        this.clientService = clientService;
    }

    @Override
    public void run(String... args) throws Exception {
        Admin admin1 = new Admin();
        admin1.setEmail("admin@isp.net");
        admin1.setFirstName("Nick");
        admin1.setLastName("Chinsen");
        admin1.setPassword("P@ssword1");
        admin1.setRoleType("ADMIN");
    }
}
