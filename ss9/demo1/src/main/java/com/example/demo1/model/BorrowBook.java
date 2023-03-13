package com.example.demo1.model;

import javax.persistence.*;

@Entity
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String code;

    @ManyToOne()
    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
    private Book book;

    public BorrowBook() {
    }

    public BorrowBook(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
