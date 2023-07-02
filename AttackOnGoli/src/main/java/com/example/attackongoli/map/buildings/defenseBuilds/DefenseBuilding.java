package com.example.attackongoli.map.buildings.defenseBuilds;

import com.example.attackongoli.map.buildings.Building;

public abstract class DefenseBuilding extends Building {

    protected int range;
    protected int impactPower;
    protected int coolDown;

    public int getImpactPower() {
        return impactPower;
    }

    public int getCoolDown() {
        return coolDown;
    }

    public int getRange() {
        return range;
    }
}
