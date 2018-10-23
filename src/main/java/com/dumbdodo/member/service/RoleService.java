package com.dumbdodo.member.service;

import com.dumbdodo.member.common.Constants;
import com.dumbdodo.member.dao.RoleDao;
import com.dumbdodo.member.dto.CreateRoleDto;
import com.dumbdodo.member.dto.RoleResponseDto;
import com.dumbdodo.member.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<RoleResponseDto> getAllRoles() {
        List<RoleResponseDto> roleResponseDtos = new ArrayList<>();
        roleDao.getAllRoles().forEach(role -> {
            roleResponseDtos.add(mapRoleEntityToDto(role));
        });
        return roleResponseDtos;
    }

    public RoleResponseDto getRoleById(Long id) {
        return mapRoleEntityToDto(roleDao.getRoleById(id));
    }

    public Role saveRole(CreateRoleDto RoleDto) {
        return roleDao.saveRole(mapDtoToRoleEntity(RoleDto));
    }

    public RoleResponseDto mapRoleEntityToDto(Role role) {
        RoleResponseDto roleResponseDto = new RoleResponseDto();
        roleResponseDto.setDescription(role.getDescription());
        roleResponseDto.setName(role.getName());
        roleResponseDto.setId(role.getId());
        return roleResponseDto;
    }

    private Role mapDtoToRoleEntity(CreateRoleDto roleDto) {
        Role role = new Role();
        role.setDescription(roleDto.getDescription());
        role.setName(roleDto.getName());
        role.setCreatedBy(Constants.ADMIN);
        role.setCreatedDate(new Date());
        role.setTenantId(1L);
        role.setUpdatedBy(Constants.ADMIN);
        role.setUpdatedDate(new Date());
        return role;
    }
}
