package com.example.attackongoli.heroes.assassins;

import com.example.attackongoli.GameLauncher;
import com.example.attackongoli.heroes.Hero;
import javafx.scene.image.Image;

public class Connor extends Hero {

    public Connor() {

        this.health = 250;
        this.damage = 60;
        this.levelRequire = 3;
        this.space = 1;
        this.speed = 3;

//        this.image = new ImageView(GameLauncher.class.getResource("Attacking_Conner.png").toString());
        this.setImage(new Image(GameLauncher.class.getResource("Attacking_Conner.png").toString()));
    }
}
