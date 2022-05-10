package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

    void remove(Blog blog);

    void update(Blog blog);

    List<Blog> search(String keyword);
}
