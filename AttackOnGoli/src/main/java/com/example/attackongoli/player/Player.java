package com.example.attackongoli.player;

import com.example.attackongoli.map.TerritoryMap;

public class Player {

    private final String username;
    private final String password;
    private int level;
    private TerritoryMap map;

    public Player(String username, String password, int level, TerritoryMap map){

        this.username = username;
        this.password = password;
        this.level = level;
        this.map = map;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getLevel() {
        return level;
    }

    public TerritoryMap getMap() {
        return map;
    }

    public void setMap(TerritoryMap map) {
        this.map = map;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
