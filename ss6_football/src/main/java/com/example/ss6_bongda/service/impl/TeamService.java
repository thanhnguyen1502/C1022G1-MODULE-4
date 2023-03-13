package com.example.ss6_bongda.service.impl;

import com.example.ss6_bongda.model.Team;
import com.example.ss6_bongda.repository.ITeamRepository;
import com.example.ss6_bongda.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamService implements ITeamService {
    @Autowired
    private ITeamRepository teamRepository;

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
