package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired private IBlogRepository iBlogRepository;
    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findByCategory(Integer categoryId) {
        return iBlogRepository.findByCategory_CategoryId(categoryId);
    }

    @Override
    public List<Blog> searchByTitle(String title) {
        return iBlogRepository.findByTitleContaining(title);
    }
}
