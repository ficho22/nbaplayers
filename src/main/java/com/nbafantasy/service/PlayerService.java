package com.nbafantasy.service;

import com.nbafantasy.model.Player;

import java.util.List;

public interface PlayerService {
    List<Player> listAll();
    Player update(Long id, String name, String team, String pos, Double age, Double ppg, Double apg, Double rpg);
    Player create(String name, String team, String pos, Double age, Double ppg, Double apg, Double rpg);
    Player delete(Long id);
    Player findByName(String name);
    Player findById(Long id);
}
