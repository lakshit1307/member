package com.dumbdodo.member.dao;

import com.dumbdodo.member.entity.MemberRole;
import com.dumbdodo.member.repository.MemberRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberRoleDao {

    @Autowired
    private MemberRoleRepository memberRoleRepository;

    public List<MemberRole> getAllMemberRoles() {
        return memberRoleRepository.findAll();
    }

    public MemberRole getMemberRoleById(Long id) {
        return memberRoleRepository.findById(id).get();
    }

    @Transactional
    public MemberRole saveMemberRole(MemberRole memberRole) {
        return memberRoleRepository.save(memberRole);
    }
}
