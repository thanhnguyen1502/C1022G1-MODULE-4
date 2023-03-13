package com.example.controller;

import com.example.model.Football;
import com.example.service.IFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class PlayerRestController {
    @Autowired
    private IFootballService footballService;

    //XEM DANH SÁCH
    @GetMapping("/home")
    public ResponseEntity<List<Football>> getAll() {
        List<Football> playerList = footballService.findAll();
        if (playerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playerList, HttpStatus.OK);
    }

    //XEM CHI TIẾT
    @GetMapping("/detail/{id}")
    public ResponseEntity<Football> detail(@PathVariable int id) {
        Football player = footballService.findById(id);

        if (player == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    //THÊM MỚI
    @PostMapping("/add")
    public ResponseEntity<List<Football>> add(@RequestBody Football football) {
        footballService.save(football);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //CẬP NHẬT
    @PutMapping("/edit/{id}")
    public ResponseEntity<List<Football>> edit(@RequestBody Football football) {
        footballService.save(football);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
