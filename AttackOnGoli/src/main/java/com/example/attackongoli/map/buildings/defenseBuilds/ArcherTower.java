package com.example.attackongoli.map.buildings.defenseBuilds;

import com.example.attackongoli.GameLauncher;
import com.example.attackongoli.map.buildings.Category;
import javafx.scene.image.ImageView;

public class ArcherTower extends DefenseBuilding {

    public ArcherTower() {

        this.coolDown = 500;
        this.impactPower = 10;
        this.range = 30;
        this.health = 70;
        this.category = Category.DEFENSE;

        this.X = 414;
        this.Y = 34;

        this.image = new ImageView(GameLauncher.class.getResource("pngkey.com-water-tower-png-1114296.png").toString());
    }
}
