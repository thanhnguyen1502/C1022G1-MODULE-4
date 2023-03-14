package com.example.controller;

import com.example.model.Player;
import com.example.service.IFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("rest/players")
public class PlayerRestController {
    @Autowired
    private IFootballService footballService;

    //XEM DANH SÁCH
    @GetMapping("")
    public ResponseEntity<List<Player>> getAll() {
        List<Player> playerList = footballService.findAll();
        if (playerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playerList, HttpStatus.OK);
    }

    //XEM CHI TIẾT
    @GetMapping("/detail/{id}")
    public ResponseEntity<Player> detail(@PathVariable int id) {
        Player player = footballService.findById(id);

        if (player == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    //THÊM MỚI
    @PostMapping("")
    public ResponseEntity<List<Player>> add(@RequestBody Player football) {
        footballService.save(football);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //CẬP NHẬT
    @PutMapping("")
    public ResponseEntity<List<Player>> edit(@RequestBody Player football) {
        footballService.save(football);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
