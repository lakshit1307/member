package com.dumbdodo.member.service;

import com.dumbdodo.member.common.Constants;
import com.dumbdodo.member.dao.MemberDao;
import com.dumbdodo.member.dto.CreateMemberDto;
import com.dumbdodo.member.dto.MemberResponseDto;
import com.dumbdodo.member.dto.RoleResponseDto;
import com.dumbdodo.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
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

    public Member saveMember(CreateMemberDto memberDto) {
        return memberDao.saveMember(mapDtoToMemberEntity(memberDto));
    }

    private Member mapDtoToMemberEntity(CreateMemberDto memberDto) {
        Member member = new Member();
        member.setDescription(memberDto.getDescription());
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
