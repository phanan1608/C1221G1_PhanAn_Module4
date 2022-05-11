package com.codegym.product_management.service;


import com.codegym.product_management.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);

}
