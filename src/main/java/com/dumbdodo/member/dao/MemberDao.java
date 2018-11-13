package com.dumbdodo.member.dao;

import com.dumbdodo.member.entity.Member;
import com.dumbdodo.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Optional<Member> getMemberByEmail(String email) {
        Member member = new Member();
        member.setEmail(email);
        Example<Member> memberExample = Example.of(member);
        return memberRepository.findOne(memberExample);
    }

    @Transactional
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}
