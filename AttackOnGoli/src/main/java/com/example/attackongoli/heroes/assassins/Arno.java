package com.example.attackongoli.heroes.assassins;

import com.example.attackongoli.GameLauncher;
import com.example.attackongoli.heroes.Hero;
import javafx.scene.image.ImageView;

public class Arno extends Hero {

    public Arno(int x, int y) {

        this.health = 200;
        this.damage = 50;
        this.levelRequire = 4;
        this.space = 1;
        this.speed = 4;

        this.image = new ImageView(GameLauncher.class.getResource("Arno.png").toString());
    }
}
