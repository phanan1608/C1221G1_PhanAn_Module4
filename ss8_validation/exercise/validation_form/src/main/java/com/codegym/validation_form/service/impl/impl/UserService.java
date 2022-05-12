package com.codegym.validation_form.service.impl.impl;

import com.codegym.validation_form.model.User;
import com.codegym.validation_form.repository.IUserRepository;
import com.codegym.validation_form.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
