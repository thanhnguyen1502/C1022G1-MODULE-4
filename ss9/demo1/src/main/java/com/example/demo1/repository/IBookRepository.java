package com.example.demo1.repository;

import com.example.demo1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
