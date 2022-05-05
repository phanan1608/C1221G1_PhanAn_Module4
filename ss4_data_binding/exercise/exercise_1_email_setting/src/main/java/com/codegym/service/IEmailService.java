package com.codegym.service;

import com.codegym.model.Email;

public interface IEmailService {
    void save(Email email);
    Email getEmail();
}
