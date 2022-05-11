package com.codegym.product_management.repository;

import com.codegym.product_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Integer> {
}
