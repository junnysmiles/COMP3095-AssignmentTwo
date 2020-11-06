package ca.gbc.services.map;

import ca.gbc.model.Admin;
import ca.gbc.services.AdminService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdminServiceMap extends AbstractMapService<Admin, Long> implements AdminService {

    @Override
    public Set<Admin> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Admin object) {
        super.delete(object);
    }

    @Override
    public Admin save(Admin object) {
        return super.save(object);
    }

    @Override
    public Admin findById(Long id) {
        return super.findById(id);
    }
}
