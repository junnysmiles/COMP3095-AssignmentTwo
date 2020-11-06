package ca.gbc.services;

import ca.gbc.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminService extends CrudRepository<Admin, Long> {
}
