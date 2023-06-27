package com.example.attackongoli.map.buildings.defenseBuilds;

import com.example.attackongoli.map.buildings.Category;

public class Cannon extends DefenseBuilding {

    public Cannon() {

        this.coolDown = 2000;
        this.health = 120;
        this.impactPower = 35;
        this.range = 40;
        this.category = Category.DEFENSE;
    }
}
