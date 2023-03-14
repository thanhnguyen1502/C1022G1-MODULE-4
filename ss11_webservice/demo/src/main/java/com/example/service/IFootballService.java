package com.example.service;

import com.example.model.Player;

import java.util.List;

public interface IFootballService {
    List<Player> findAll();

    void save(Player player);

    Player findById(int id);
}
