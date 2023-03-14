package com.example.repository;

import com.example.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFootballRepository extends JpaRepository<Player, Integer> {

}
