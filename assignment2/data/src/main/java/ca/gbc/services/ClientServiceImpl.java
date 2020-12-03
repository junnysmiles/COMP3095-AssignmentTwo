/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 02/12/2020 -Nick created file
 * Description: Implementation of the Client service
 * ****************************************************************************************************************/
package ca.gbc.services;

import ca.gbc.model.Client;
import ca.gbc.repositories.ClientRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public Set findAll() {
        Set<Client> clients = new HashSet<>();
        clientRepo.findAll().forEach(clients::add);
        return clients;
    }

    @Override
    public Client findById(Long aLong) {
        return clientRepo.findById(aLong).orElse(null);
    }

    @Override
    public Client save(Client object) {
        return clientRepo.save(object);
    }

    @Override
    public void delete(Client object) {
        clientRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        clientRepo.deleteById(aLong);
    }
}
