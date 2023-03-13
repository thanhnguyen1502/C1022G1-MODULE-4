package com.example.ss6_bongda.repository;

import com.example.ss6_bongda.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamRepository extends JpaRepository<Team, Integer> {
}
