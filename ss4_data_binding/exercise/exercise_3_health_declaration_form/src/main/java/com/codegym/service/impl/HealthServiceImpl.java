package com.codegym.service.impl;

import com.codegym.model.Health;
import com.codegym.repository.IHealthRepository;
import com.codegym.service.IHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthServiceImpl implements IHealthService {
    @Autowired
    IHealthRepository healthRepository;

    @Override
    public void save(Health health) {
        healthRepository.save(health);
    }

    @Override
    public Health getHealth() {
        return healthRepository.getHealth();
    }
}
