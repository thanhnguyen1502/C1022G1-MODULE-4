package com.example.demo1.service;

import com.example.demo1.model.BorrowBook;

public interface IBorrowService {
    void save(BorrowBook borrowBook);

    BorrowBook findByCode(String code);

    void remove(Integer id);
}
