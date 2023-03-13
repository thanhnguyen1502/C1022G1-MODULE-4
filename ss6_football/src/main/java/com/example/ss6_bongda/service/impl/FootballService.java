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
    public void remove(Integer id) {
        footballRepository.deleteById(id);
    }

    @Override
    public void save(Football football) {
        footballRepository.save(football);
    }


    @Override
    public Page<Football> findAllByNameAllBirthday(String keySearch, Pageable pageable) {
        return footballRepository.findAllByNameContaining(keySearch , pageable);
    }

    @Override
    public Football findById(Integer id) {
        return footballRepository.findById(id).get();
    }
}
