package com.example.springsecurity.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhantianxin
 * @version 1.0
 * @date 2022/10/11 14:11
 */

@Service("userDetailsService")
public class UserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //这里设定角色
        List<GrantedAuthority> authList = AuthorityUtils.commaSeparatedStringToAuthorityList("role1");
        return new User("role1",new BCryptPasswordEncoder().encode("123"),authList);
    }

}
