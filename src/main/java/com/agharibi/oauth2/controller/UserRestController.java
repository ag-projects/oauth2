package com.agharibi.oauth2.controller;

import com.agharibi.oauth2.model.User;
import com.agharibi.oauth2.persistence.UserRepository;
import com.agharibi.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public UserRestController() {
    }

    @RequestMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @RequestMapping("{id}")
    public User view(@PathVariable("id") User user) {
        return user;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid User user) throws Exception {
        return userService.registerNewUser(user);
    }

    @RequestMapping(value = "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }
}
