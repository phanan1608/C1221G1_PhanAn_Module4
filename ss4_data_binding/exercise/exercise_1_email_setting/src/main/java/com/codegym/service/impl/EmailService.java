package com.codegym.service.impl;

import com.codegym.model.Email;
import com.codegym.repository.IEmailRepository;
import com.codegym.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {
    @Autowired
    IEmailRepository emailRepository;

    @Override
    public void save(Email email) {
            emailRepository.save(email);
    }

    @Override
    public Email getEmail() {
        return emailRepository.getEmail();
    }
}
