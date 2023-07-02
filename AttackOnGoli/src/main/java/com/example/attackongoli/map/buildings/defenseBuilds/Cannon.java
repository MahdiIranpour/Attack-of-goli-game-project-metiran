package com.example.attackongoli.map.buildings.defenseBuilds;

import com.example.attackongoli.GameLauncher;
import com.example.attackongoli.map.buildings.Category;
import javafx.scene.image.ImageView;

public class Cannon extends DefenseBuilding {

    public Cannon() {

        this.coolDown = 2000;
        this.health = 120;
        this.impactPower = 35;
        this.range = 40;
        this.category = Category.DEFENSE;

        this.X = 262;
        this.Y = 306;

        this.image = new ImageView(GameLauncher.class.getResource("cannon.png").toString());
    }
}
