package com.dumbdodo.member.service;

import com.dumbdodo.member.common.Constants;
import com.dumbdodo.member.dao.MemberDao;
import com.dumbdodo.member.dao.MemberRoleDao;
import com.dumbdodo.member.dao.RoleDao;
import com.dumbdodo.member.dto.CreateMemberRoleDto;
import com.dumbdodo.member.dto.MemberRoleResponseDto;
import com.dumbdodo.member.entity.MemberRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberRoleService {

    @Autowired
    private MemberRoleDao memberRoleDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private RoleDao roleDao;

    public List<MemberRoleResponseDto> getAllMemberRoles() {
        List<MemberRoleResponseDto> roleResponseDtos = new ArrayList<>();
        memberRoleDao.getAllMemberRoles().forEach(memberRole -> {
            roleResponseDtos.add(mapMemberRoleEntityToDto(memberRole));
        });
        return roleResponseDtos;
    }

    public MemberRoleResponseDto getMemberRolesById(Long id) {
        return mapMemberRoleEntityToDto(memberRoleDao.getMemberRoleById(id));
    }

    public MemberRole saveMemberRoles(CreateMemberRoleDto createMemberRoleDto) {
        return memberRoleDao.saveMemberRole(mapDtoToMemberRoleEntity(createMemberRoleDto));
    }

    public MemberRoleResponseDto mapMemberRoleEntityToDto(MemberRole memberRole) {
        MemberRoleResponseDto memberResponseDto = new MemberRoleResponseDto();
        memberResponseDto.setId(memberRole.getId());
        memberResponseDto.setRole(roleService.mapRoleEntityToDto(memberRole.getRole()));
        memberResponseDto.setMember(memberService.mapEntityToDto(memberRole.getMember()));
        return memberResponseDto;
    }

    private MemberRole mapDtoToMemberRoleEntity(CreateMemberRoleDto createMemberRoleDto) {
        MemberRole memberRole = new MemberRole();
        memberRole.setMember(memberDao.getMemberById(createMemberRoleDto.getMemberId()));
        memberRole.setRole(roleDao.getRoleById(createMemberRoleDto.getRoleId()));
        memberRole.setCreatedBy(Constants.ADMIN);
        memberRole.setCreatedDate(new Date());
        memberRole.setTenantId(1L);
        memberRole.setUpdatedBy(Constants.ADMIN);
        memberRole.setUpdatedDate(new Date());
        return memberRole;
    }
}
