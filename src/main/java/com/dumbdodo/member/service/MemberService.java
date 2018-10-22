package com.dumbdodo.member.service;

import com.dumbdodo.member.common.Constants;
import com.dumbdodo.member.dao.MemberDao;
import com.dumbdodo.member.dto.CreateMemberDto;
import com.dumbdodo.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    public List<Member> getAllMembers() {
        return memberDao.getAllMembers();
    }

    public Member getMemberById(Long id) {
        return memberDao.getMemberById(id);
    }

    public Member saveMember(CreateMemberDto memberDto) {
        return memberDao.saveMember(mapDtoToMemberEntity(memberDto));
    }

    private Member mapDtoToMemberEntity(CreateMemberDto memberDto) {
        Member member = new Member();
        member.setDescription(memberDto.getDescription());
        member.setEmail(memberDto.getEmail());
        member.setPassword(memberDto.getPassword());
        member.setName(memberDto.getName());
        member.setCreatedBy(Constants.ADMIN);
        member.setCreatedDate(new Date());
        member.setTenantId(1L);
        member.setUpdatedBy(Constants.ADMIN);
        member.setUpdatedDate(new Date());
        return member;
    }
}
