package com.codegym.repository;

import com.codegym.model.Email;

public interface IEmailRepository {
    void save(Email email);
    Email getEmail();
}
