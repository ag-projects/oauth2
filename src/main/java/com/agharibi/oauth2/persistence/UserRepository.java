package com.agharibi.oauth2.persistence;

import com.agharibi.oauth2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
