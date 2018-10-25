package com.agharibi.oauth2.service;

import com.agharibi.oauth2.model.User;

public interface UserService {

    /**
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * @param user
     * @return
     * @throws Exception
     */
    User registerNewUser(User user) throws Exception;
}
