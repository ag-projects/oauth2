package com.agharibi.oauth2.security;

import com.agharibi.oauth2.model.User;
import com.agharibi.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = this.userService.findByEmail(userName);
        if (user == null) {
            throw new IllegalArgumentException("Username was not found " + userName);
        }
        return new org.springframework.security.core.userdetails.User(userName, user.getPassword(), new ArrayList<>());
    }
}
