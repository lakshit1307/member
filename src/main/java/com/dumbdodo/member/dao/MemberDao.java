package com.dumbdodo.member.dao;

import com.dumbdodo.member.entity.Member;
import com.dumbdodo.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberDao {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).get();
    }

    @Transactional
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}
