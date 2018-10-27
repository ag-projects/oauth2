package com.agharibi.oauth2.security;

import com.agharibi.oauth2.model.User;
import com.agharibi.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SetupBean {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @PostConstruct
    public void setupUser() throws Exception {
        User user = new User("armen@yahoo.com", encoder.encode("Secured123!"));
        this.userService.registerNewUser(user);
    }
}
