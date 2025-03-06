package com.nbafantasy.repository;

import com.nbafantasy.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("select p from Player p order by p.ppg desc ")
    List<Player> findAllSortedByPpg();
    Player findByName(String name);
}
