package com.example.attackongoli.map.buildings.defenseBuilds;

import com.example.attackongoli.map.buildings.Category;
import javafx.scene.image.Image;

public class Cannon extends DefenseBuilding {

    public Cannon() {

        this.coolDown = 2000;
        this.health = 120;
        this.impactPower = 35;
        this.range = 40;
        this.category = Category.DEFENSE;

//        this.X = 182;
//        this.Y = 236;
//
//        this.image = new ImageView(GameLauncher.class.getResource("cannon.png").toString());

        this.setImage(new Image("cannon.png"));
    }
}
