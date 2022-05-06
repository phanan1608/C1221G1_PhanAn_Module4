package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1,new Product("1","iphone X","1000","10"));
        products.put(2,new Product("2","iphone 11","1200","30"));
        products.put(3,new Product("3","iphone 12","1400","20"));
        products.put(4,new Product("4","iphone 13","1500","40"));
        products.put(5,new Product("5","iphone 14","2000","10"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(Integer.valueOf(product.getId()),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
