package com.example.attackongoli.heroes;

import javafx.scene.image.ImageView;

public class Hero extends ImageView{

    protected int health;
    protected int damage;
    protected int speed;
    protected int space;
    protected int levelRequire;
//    protected ImageView image;
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpace() {
        return space;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLevelRequire() {
        return levelRequire;
    }
}
