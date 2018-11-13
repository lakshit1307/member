package com.dumbdodo.member.repository;

import com.dumbdodo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

//    @Query("SELECT * FROM M_MEMBER WHERE MEMBER_EMAIL=:mail")
//    List<Member> getMemersByEmail(@Param("mail") String email);
}
