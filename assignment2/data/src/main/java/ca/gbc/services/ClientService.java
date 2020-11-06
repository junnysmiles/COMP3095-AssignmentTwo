package ca.gbc.services;

import ca.gbc.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientService extends CrudRepository<Client, Long> {
}
