package com.example.attackongoli.heroes.assassins;

import com.example.attackongoli.GameLauncher;
import com.example.attackongoli.heroes.Hero;
import javafx.scene.image.ImageView;

public class Connor extends Hero {

    public Connor(int x, int y) {

        this.health = 250;
        this.damage = 60;
        this.levelRequire = 3;
        this.space = 1;
        this.speed = 3;

        this.image = new ImageView(GameLauncher.class.getResource("Connor.png").toString());
    }
}
