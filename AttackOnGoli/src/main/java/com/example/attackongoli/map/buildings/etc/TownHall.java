package com.example.attackongoli.map.buildings.etc;

import com.example.attackongoli.GameLauncher;
import com.example.attackongoli.map.buildings.Building;
import com.example.attackongoli.map.buildings.Category;
import javafx.scene.image.ImageView;

public class TownHall extends Building {

    public TownHall(){

        this.category = Category.ETC;
        this.health = 100;

        this.image = new ImageView(GameLauncher.class.getResource("townhall.png").toString());

        this.X = 387;
        this.Y = 198;
    }
}
