package com.codegym.repository.impl;

import com.codegym.model.Email;
import com.codegym.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepository implements IEmailRepository {
    private Email email = new Email();
    @Override
    public void save(Email email) {
        this.email = email;
    }

    @Override
    public Email getEmail() {
        return email;
    }

}
