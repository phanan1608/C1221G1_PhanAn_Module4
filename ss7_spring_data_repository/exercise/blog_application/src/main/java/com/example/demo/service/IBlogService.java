package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(String keyword, Pageable pageable);

    void save(Blog blog);

    Blog findById(Integer id);

    void remove(Blog blog);

    void update(Blog blog);

}
