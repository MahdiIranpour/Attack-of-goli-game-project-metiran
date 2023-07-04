package com.example.attackongoli.map.buildings.etc;

import com.example.attackongoli.GameLauncher;
import com.example.attackongoli.map.buildings.Building;
import com.example.attackongoli.map.buildings.Category;
import javafx.scene.image.Image;

public class TownHall extends Building {

    public TownHall(){

        this.category = Category.ETC;
        this.health = 350;

//        this.image = new ImageView(GameLauncher.class.getResource("townhall.png").toString());
//
//        this.X = 317;
//        this.Y = 138;

        this.setImage(new Image(GameLauncher.class.getResource("townhall.png").toString()));

        this.setFitHeight(150);
        this.setFitWidth(150);
        this.setX(150);
        this.setY(70);
    }
}
