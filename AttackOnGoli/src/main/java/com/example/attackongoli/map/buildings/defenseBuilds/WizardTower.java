package com.example.attackongoli.map.buildings.defenseBuilds;

import com.example.attackongoli.map.buildings.Category;

public class WizardTower extends DefenseBuilding {

    public WizardTower(){

        this.coolDown = 1000;
        this.health = 150;
        this.impactPower = 25;
        this.range = 30;
        this.category = Category.DEFENSE;
    }
}
