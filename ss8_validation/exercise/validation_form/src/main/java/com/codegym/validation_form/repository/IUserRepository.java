package com.codegym.validation_form.repository;

import com.codegym.validation_form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
