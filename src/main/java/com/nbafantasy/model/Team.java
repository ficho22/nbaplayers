package com.nbafantasy.model;

public class Team {
    private Long id;
    private String name;
    private String city;
    private Integer wins;
    private Integer losses;


    public Team(){}
    public Team(Long id, String name, String city, Integer wins, Integer losses) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.wins = wins;
        this.losses = losses;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }
}
