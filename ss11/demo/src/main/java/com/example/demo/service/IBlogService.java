package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    List<Blog> findByCategory(Integer categoryId);

    List<Blog> searchByTitle(String title);
}
