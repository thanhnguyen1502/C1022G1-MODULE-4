package com.example.demo1.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;
    private String name;
    private String author;
    private String description;
    private Integer amount;

    @OneToMany(mappedBy = "book")
    private Set<BorrowBook> borrowBooks;

    public Book() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Set<BorrowBook> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(Set<BorrowBook> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }
}
