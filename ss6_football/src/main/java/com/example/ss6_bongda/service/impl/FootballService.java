package com.example.ss6_bongda.service.impl;

import com.example.ss6_bongda.model.Football;
import com.example.ss6_bongda.repository.IFootballRepository;
import com.example.ss6_bongda.service.IFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FootballService implements IFootballService {
    @Autowired
    private IFootballRepository footballRepository;


    @Override
    public List<Football> findAll() {
        return footballRepository.findAll();
    }

    @Override
    public void save(Football player) {
        footballRepository.save(player);
    }

    @Override
    public Football findById(int id) {
        return footballRepository.findById(id).get();
    }
}
