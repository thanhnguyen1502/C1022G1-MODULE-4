package com.example.service;

import com.example.model.Football;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFootballService {
    List<Football> findAll();

    void save(Football player);

    Football findById(int id);
}
