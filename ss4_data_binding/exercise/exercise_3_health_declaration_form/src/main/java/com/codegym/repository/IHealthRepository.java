package com.codegym.repository;

import com.codegym.model.Health;

public interface IHealthRepository {
    void save(Health health);
    Health getHealth();
}
