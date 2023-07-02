package com.example.attackongoli.map.buildings.defenseBuilds;

import com.example.attackongoli.map.buildings.Category;

public class WizardTower extends DefenseBuilding {

    public WizardTower(){

        this.coolDown = 1000;
        this.health = 150;
        this.impactPower = 25;
        this.range = 30;
        this.category = Category.DEFENSE;

//        this.X = 458;
//        this.Y = 222;
//
//        this.image = new ImageView(GameLauncher.class.getResource("Wizard_Tower.png").toString());
    }
}
