package com.example.ss6_bongda.service;

import com.example.ss6_bongda.model.Football;
import com.example.ss6_bongda.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFootballService {
    List<Football> findAll();

    void save(Football player);

    Football findById(int id);
}
