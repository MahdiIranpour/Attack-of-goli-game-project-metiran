package com.example.attackongoli.map.buildings.defenseBuilds;

import com.example.attackongoli.GameLauncher;
import com.example.attackongoli.map.buildings.Category;
import javafx.scene.image.Image;

public class ArcherTower extends DefenseBuilding {

    public ArcherTower() {

        this.coolDown = 500;
        this.impactPower = 200;
        this.range = 30;
        this.health = 170;
        this.category = Category.DEFENSE;

//        this.X = 334;
//        this.Y = 8;
//
//        this.image = new ImageView(GameLauncher.class.getResource("pngkey.com-water-tower-png-1114296.png").toString());

        this.setImage(new Image(GameLauncher.class.getResource("pngkey.com-water-tower-png-1114296.png").toString()));

        this.setFitHeight(100);
        this.setFitWidth(80);
        this.setX(225);
        this.setY(110);
    }
}
