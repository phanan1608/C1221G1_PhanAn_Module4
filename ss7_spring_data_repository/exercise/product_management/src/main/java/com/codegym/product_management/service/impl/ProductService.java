package com.codegym.product_management.service.impl;


import com.codegym.product_management.model.Product;
import com.codegym.product_management.repository.IProductRepository;
import com.codegym.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        productRepository.delete(findById(id));
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
