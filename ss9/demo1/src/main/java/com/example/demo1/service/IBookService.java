package com.example.demo1.service;

import com.example.demo1.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);
}
