package com.edu.pe.usermicroservice.users.domain.service;

import com.crudjpa.service.ICrudService;
import com.edu.pe.usermicroservice.users.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface IUserService extends ICrudService<User, Long> {
    Optional<User> findUserByUsernameAndPassword(String username, String password);
    Optional<User> findUserByUsername(String username);
}
