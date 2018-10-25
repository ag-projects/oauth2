package com.agharibi.oauth2.controller;

import com.agharibi.oauth2.model.User;
import com.agharibi.oauth2.persistence.UserRepository;
import com.agharibi.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public UserRestController() {
    }


    @ResponseBody
    @RequestMapping
    public List<User> list() {
        return this.userRepository.findAll();
    }


    @ResponseBody
    @RequestMapping("{id}")
    public User view(@PathVariable("id") User user) {
        return user;
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public User create(@Valid User user) throws Exception {
        return this.userService.registerNewUser(user);
    }


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "delete/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        this.userRepository.deleteById(id);
    }
}
