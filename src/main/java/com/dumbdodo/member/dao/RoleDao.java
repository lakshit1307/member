package com.dumbdodo.member.dao;

import com.dumbdodo.member.entity.Role;
import com.dumbdodo.member.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleDao {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Transactional
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
