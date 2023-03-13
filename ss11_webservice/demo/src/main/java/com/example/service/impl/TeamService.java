package com.example.service.impl;

import com.example.model.Team;
import com.example.repository.ITeamRepository;
import com.example.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamService implements ITeamService {
    @Autowired
    private ITeamRepository iTeamRepository;
    @Override
    public List<Team> findAll() {
        return iTeamRepository.findAll();
    }
}
