package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;
    private String categoryName;

    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private Set<Blog> blogSet;

    public Category() {

    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Blog> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<Blog> blogSet) {
        this.blogSet = blogSet;
    }
}
