package com.example.demo1.service.impl;

import com.example.demo1.model.BorrowBook;
import com.example.demo1.repository.IBorrowBookRepository;
import com.example.demo1.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;

public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowBookRepository iBorrowBookRepository;

    @Override
    public void save(BorrowBook borrowBook) {
        iBorrowBookRepository.save(borrowBook);
    }

    @Override
    public BorrowBook findByCode(String code) {
        return iBorrowBookRepository.findByCode(code);
    }

    @Override
    public void remove(Integer id) {
        iBorrowBookRepository.deleteById(id);
    }
}
