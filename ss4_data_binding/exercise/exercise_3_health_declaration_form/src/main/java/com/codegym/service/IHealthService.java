package com.codegym.service;

import com.codegym.model.Health;

public interface IHealthService {
    void save(Health health);
    Health getHealth();
}
