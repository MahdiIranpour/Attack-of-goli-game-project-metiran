package com.example.attackongoli.heroes.assassins;

import com.example.attackongoli.GameLauncher;
import com.example.attackongoli.heroes.Hero;
import javafx.scene.image.Image;

public class Bear extends Hero {

    public Bear() {

        this.health = 400;
        this.damage = 25;
        this.levelRequire = 1;
        this.space = 3;
        this.speed = 2;

//        this.image = new ImageView(GameLauncher.class.getResource("Cyndicate.png").toString());
        this.setImage(new Image(GameLauncher.class.getResource("Attacking_bear.png").toString()));
    }
}
