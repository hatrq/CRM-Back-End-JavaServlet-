package main.service;

import main.entity.Role;
import main.repository.RoleRepository;

import java.util.List;

public class RoleService {
    private RoleRepository roleRepository = new RoleRepository();

    public boolean addRole(String name, String description){
        return roleRepository.addRole(name, description) > 0;
    }

    public List<Role> showRole(){
        return roleRepository.showRole();
    }

    public boolean deleteRoleById(int id){
        return roleRepository.deleteRoleById(id) > 0;
    }

    public boolean upDateRoleById(int id, String name, String description){
        return roleRepository.updateRoleById(id, name, description) > 0;
    }
}
