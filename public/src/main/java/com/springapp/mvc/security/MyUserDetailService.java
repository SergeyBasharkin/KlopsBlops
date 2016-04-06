package com.springapp.mvc.security;

import com.springapp.mvc.common.UserInfo;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Gataullin Kamil
 * 28.03.2016 20:55
 */
@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserInfo userInfo = userService.getUserByLogin(login);
        if (userInfo == null) throw new UsernameNotFoundException("User with name " + login + " not found");
        return new MyUserDetail(userInfo);
    }

}
