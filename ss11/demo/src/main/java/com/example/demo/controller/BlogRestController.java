package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blogs")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public ResponseEntity<List<Blog>> getList(@RequestParam(value = "search", defaultValue = "") String titleSearch) {
        List<Blog> blogList = iBlogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> blogDetail(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);

        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/list-by-category/{categoryId}")
    public ResponseEntity<List<Blog>> findByCategory(@PathVariable Integer categoryId) {
        if (iBlogService.findByCategory(categoryId).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(iBlogService.findByCategory(categoryId), HttpStatus.OK);
    }
}
