package com.example.attackongoli.heroes.assassins;

import com.example.attackongoli.heroes.Hero;
import javafx.scene.image.Image;

public class Arno extends Hero {

    public Arno() {

        this.health = 200;
        this.damage = 50;
        this.levelRequire = 4;
        this.space = 1;
        this.speed = 4;

//        this.image = new ImageView(GameLauncher.class.getResource("Arno.png").toString());
        this.setImage(new Image("Arno.png"));
    }
}
