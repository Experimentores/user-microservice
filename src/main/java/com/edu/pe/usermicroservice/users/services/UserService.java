package com.edu.pe.usermicroservice.users.services;

import com.crudjpa.service.impl.CrudService;
import com.edu.pe.usermicroservice.users.domain.model.User;
import com.edu.pe.usermicroservice.users.domain.service.IUserService;
import com.edu.pe.usermicroservice.users.persistence.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends CrudService<User, Long> implements IUserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findUserByUsernameAndPassword(username, password);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
