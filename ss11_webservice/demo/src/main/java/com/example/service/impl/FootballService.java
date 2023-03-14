package com.example.service.impl;


import com.example.model.Player;
import com.example.repository.IFootballRepository;
import com.example.service.IFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballService implements IFootballService {
    @Autowired
    private IFootballRepository iFootballRepository;

    @Override
    public List<Player> findAll() {
        return iFootballRepository.findAll();
    }

    @Override
    public void save(Player player) {
        iFootballRepository.save(player);
    }

    @Override
    public Player findById(int id) {
        return iFootballRepository.getById(id);
    }
}
