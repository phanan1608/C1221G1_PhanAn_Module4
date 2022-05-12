package com.codegym.validation_form.service.impl;

import com.codegym.validation_form.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);

}
