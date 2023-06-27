package com.example.attackongoli.player;

import com.example.attackongoli.map.TerritoryMap;

public class Player {

    private String username;
    private String Password;
    private int level;
    private TerritoryMap map;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return Password;
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
