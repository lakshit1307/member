package com.dumbdodo.member.service;

import com.dumbdodo.member.common.Constants;
import com.dumbdodo.member.dao.MemberDao;
import com.dumbdodo.member.dao.elastic.AuditDao;
import com.dumbdodo.member.dto.CreateMemberDto;
import com.dumbdodo.member.dto.MemberResponseDto;
import com.dumbdodo.member.dto.RoleResponseDto;
import com.dumbdodo.member.entity.Member;
import com.dumbdodo.member.entity.elastic.Audit;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuditDao auditDao;

    public List<MemberResponseDto> getAllMembers() {
        List<MemberResponseDto> memberResponseDtos = new ArrayList<>();
        memberDao.getAllMembers().forEach(member -> {
            memberResponseDtos.add(mapEntityToDto(member));
        });
        return memberResponseDtos;
    }

    public MemberResponseDto getMemberById(Long id) {
        String key = "member";
        MemberResponseDto memberResponseDto = (MemberResponseDto) redisService.getFromRedis(key, id);
        if (memberResponseDto == null) {
            memberResponseDto = mapEntityToDto(memberDao.getMemberById(id));
            redisService.putDataToRedis(key, id, memberResponseDto);
        }
        return memberResponseDto;
    }

    public Member saveMember(CreateMemberDto memberDto) throws JsonProcessingException {
        Audit audit = new Audit();
        audit.setEntityType("MEMBER");
        Member member = memberDao.saveMember(mapDtoToMemberEntity(memberDto));
        audit.setEntityId(member.getId());
        audit.setChangedBy(member.getUpdatedBy());
        audit.setAfterChange(new ObjectMapper().writeValueAsString(memberDto));
        audit.setCreatedBy(Constants.ADMIN);
        audit.setUpdatedBy(Constants.ADMIN);
        audit.setCreatedDate(new Date());
        audit.setUpdatedDate(new Date());
        audit.setTenantId(member.getTenantId());
        auditDao.save(audit);
        return member;
    }

    private Member mapDtoToMemberEntity(CreateMemberDto memberDto) {
        Member member = new Member();
        member.setDescription("System");
        member.setEmail(memberDto.getEmail());
        member.setPassword(bCryptPasswordEncoder.encode(memberDto.getPassword()));
        member.setName(memberDto.getName());
        member.setCreatedBy(Constants.ADMIN);
        member.setCreatedDate(new Date());
        member.setTenantId(1L);
        member.setUpdatedBy(Constants.ADMIN);
        member.setUpdatedDate(new Date());
        return member;
    }

    public MemberResponseDto mapEntityToDto(Member member) {
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.setDescription(member.getDescription());
        memberResponseDto.setEmail(member.getEmail());
        memberResponseDto.setId(member.getId());
        memberResponseDto.setName(member.getName());
        Set<RoleResponseDto> roleResponseDtos = new HashSet<>();
        member.getMemberRoles().forEach(memberRole -> {
            roleResponseDtos.add(roleService.mapRoleEntityToDto(memberRole.getRole()));
        });
        memberResponseDto.setRoles(roleResponseDtos);
        return memberResponseDto;

    }
}
