package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
@CrossOrigin("*")
public class CategoryRestController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/list")
    public ResponseEntity<List<Category>> getList() {
        List<Category> categoryList = iCategoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
