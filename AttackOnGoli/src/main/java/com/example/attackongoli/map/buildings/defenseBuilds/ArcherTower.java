package com.example.attackongoli.map.buildings.defenseBuilds;

import com.example.attackongoli.map.buildings.Category;

public class ArcherTower extends DefenseBuilding {

    public ArcherTower() {

        this.coolDown = 500;
        this.impactPower = 10;
        this.range = 30;
        this.health = 70;
        this.category = Category.DEFENSE;
    }
}
