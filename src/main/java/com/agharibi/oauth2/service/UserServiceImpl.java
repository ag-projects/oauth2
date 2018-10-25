package com.agharibi.oauth2.service;

import com.agharibi.oauth2.model.User;
import com.agharibi.oauth2.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User registerNewUser(User user) throws Exception {
        if(emailExist(user.getEmail())) {
            throw new IllegalArgumentException("There is an account with that email address " + user.getEmail());
        }
        return this.userRepository.save(user);
    }

    private boolean emailExist(String email) {
        User user = this.userRepository.findByEmail(email);
        return user != null;
    }
}
