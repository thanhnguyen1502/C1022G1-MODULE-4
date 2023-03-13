package com.example.ss6_bongda.repository;

import com.example.ss6_bongda.model.Football;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFootballRepository extends JpaRepository<Football, Integer> {
    Page<Football> findAllByNameContaining(String keySearch, Pageable pageable);
}
