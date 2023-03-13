package com.example.dto;

import java.util.HashMap;
import java.util.Map;

public class FavoriteDto {
    private Map<FootballDto, Integer> playerMap = new HashMap<>();

    public FavoriteDto() {
    }

    public Map<FootballDto, Integer> getPlayerMap() {
        return playerMap;
    }

    public void setPlayerMap(Map<FootballDto, Integer> playerMap) {
        this.playerMap = playerMap;
    }

    public void addFavoritePlayer(FootballDto playerDto) {
        if (playerMap.containsKey(playerDto)) {
            Integer view = playerMap.get(playerDto);
            playerMap.replace(playerDto, view +1);
        } else {
            playerMap.put(playerDto,1);
        }
    }
}
