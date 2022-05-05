package com.codegym.repository.impl;

import com.codegym.model.Health;
import com.codegym.repository.IHealthRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HealthRepositoryImpl implements IHealthRepository {
    private Health health = new Health();
    @Override
    public void save(Health health) {
            this.health = health;
    }

    @Override
    public Health getHealth() {
        return health;
    }
}
