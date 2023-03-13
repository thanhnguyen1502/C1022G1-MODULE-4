package com.example.service;

import com.example.model.Football;

import java.util.List;
import java.util.Optional;

public interface IFootballService {
    List<Football> findAll();

    Optional<Football> findById(int id);
}
