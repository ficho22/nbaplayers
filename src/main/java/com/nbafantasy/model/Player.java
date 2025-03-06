package com.nbafantasy.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String team;

    private String pos;

    private Double age;

    private Double ppg;

    private Double rpg;

    private Double apg;


    public Player(){}

    public Player(String name, String team, String pos,
                  Double age, Double ppg,
                  Double rpg, Double apg) {
        this.name = name;
        this.team = team;
        this.pos = pos;
        this.age = age;
        this.ppg = ppg;
        this.rpg = rpg;
        this.apg = apg;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getPos() {
        return pos;
    }

    public Double getAge() {
        return age;
    }

    public Double getPpg() {
        return ppg;
    }

    public Double getRpg() {
        return rpg;
    }

    public Double getApg() {
        return apg;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public void setPpg(Double ppg) {
        this.ppg = ppg;
    }

    public void setRpg(Double rpg) {
        this.rpg = rpg;
    }

    public void setApg(Double apg) {
        this.apg = apg;
    }
}






