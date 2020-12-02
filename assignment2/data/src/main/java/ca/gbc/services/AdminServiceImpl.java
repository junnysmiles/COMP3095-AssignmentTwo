/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 02/12/2020 -Nick created file
 * Description: Implementation of the Admin service
 * ****************************************************************************************************************/
package ca.gbc.services;

import ca.gbc.model.Admin;
import ca.gbc.repositories.AdminRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService{
    private final AdminRepo adminRepo;

    public AdminServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public Set<Admin> findAll() {
        Set<Admin> admins = new HashSet<>();
        adminRepo.findAll().forEach(admins::add);
        return admins;
    }

    @Override
    public Admin findById(Long aLong) {
        return adminRepo.findById(aLong).orElse(null);
    }

    @Override
    public Admin save(Admin object) {
        return adminRepo.save(object);
    }

    @Override
    public void delete(Admin object) {
        adminRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        adminRepo.deleteById(aLong);
    }
}
