package com.example.demo1.repository;

import com.example.demo1.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook, Integer> {
    BorrowBook findByCode(String code);
}
