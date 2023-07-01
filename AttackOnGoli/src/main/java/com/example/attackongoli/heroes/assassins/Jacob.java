package com.example.attackongoli.heroes.assassins;

import com.example.attackongoli.GameLauncher;
import com.example.attackongoli.heroes.Hero;
import javafx.scene.image.ImageView;

public class Jacob extends Hero {

    public Jacob(int x, int y) {

        this.health = 180;
        this.damage = 50;
        this.levelRequire = 2;
        this.space = 1;
        this.speed = 5;

        this.image = new ImageView(GameLauncher.class.getResource("Cyndicate.png").toString());
    }
}
