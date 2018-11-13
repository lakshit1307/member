package com.dumbdodo.member.service;

import com.dumbdodo.member.dao.MemberDao;
import com.dumbdodo.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl /**implements UserDetailsService**/{

//    @Autowired
//    private MemberDao memberDao;
//
//    @Override
//    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
//
//        try {
//            Optional<Member> member = memberDao.getMemberByEmail(email);
//            Member user = member.isPresent() ? member.get() : null;
//            if (user == null) {
//                throw new UsernameNotFoundException("No user found with username: " + email);
//            }
//
//            List<String> roles = new ArrayList<>();
//            roles.add("USER");
//            return new User(user.getEmail(), user.getPassword(), true, true, true, true, getAuthorities(roles));
//        } catch (final Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static List<GrantedAuthority> getAuthorities(List<String> roles) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (String role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role));
//        }
//        return authorities;
//    }

}
