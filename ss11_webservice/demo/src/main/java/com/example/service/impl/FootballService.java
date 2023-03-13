package com.example.service.impl;


import com.example.model.Football;
import com.example.repository.IFootballRepository;
import com.example.service.IFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballService implements IFootballService {
    @Autowired
    private IFootballRepository iFootballRepository;

    @Override
    public List<Football> findAll() {
        return iFootballRepository.findAll();
    }

    @Override
    public void save(Football player) {
        iFootballRepository.save(player);
    }

    @Override
    public Football findById(int id) {
        return iFootballRepository.getById(id);
    }
}
