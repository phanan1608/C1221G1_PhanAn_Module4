package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findAllByTitleContaining(String keyword);

//    @Query("SELECT b FROM Blog b WHERE b.title LIKE %?1%")
    Page<Blog> findAllByTitleContaining(String keyword, Pageable pageable);
}
