package com.example.demo1.service.impl;

import com.example.demo1.model.Book;
import com.example.demo1.repository.IBookRepository;
import com.example.demo1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).get();
    }
}
