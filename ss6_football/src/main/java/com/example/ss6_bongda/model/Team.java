package com.example.ss6_bongda.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Football> footballList;

    public Team() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Football> getFootballList() {
        return footballList;
    }

    public void setFootballList(List<Football> footballList) {
        this.footballList = footballList;
    }

}
