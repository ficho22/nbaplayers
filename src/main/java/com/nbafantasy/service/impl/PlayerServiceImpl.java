package com.nbafantasy.service.impl;

import com.nbafantasy.model.Player;
import com.nbafantasy.model.exception.InvalidPlayerException;
import com.nbafantasy.repository.PlayerRepository;
import com.nbafantasy.service.PlayerService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> listAll() {

        return playerRepository.findAllSortedByPpg();
    }

    @Override
    public Player findByName(String name) {
        return playerRepository.findByName(name);
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.findById(id).orElseThrow(InvalidPlayerException::new);
    }

    @Override
    public Player delete(Long id) {
        Player player = this.findById(id);
        playerRepository.delete(player);
        return player;
    }

    @Override
    public Player update(Long id, String name, String team, String pos, Double age, Double ppg, Double apg, Double rpg) {
        Player player = this.findById(id);
        player.setName(name);
        player.setTeam(team);
        player.setPos(pos);
        player.setAge(age);
        player.setPpg(ppg);
        player.setApg(apg);
        player.setRpg(rpg);
        return playerRepository.save(player);
    }

    @Override
    public Player create(String name, String team, String pos, Double age, Double ppg, Double apg, Double rpg) {
        Player player = new Player(name, team, pos, age, ppg, apg, rpg);
        return playerRepository.save(player);
    }
}
