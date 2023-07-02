package com.example.attackongoli.map.buildings;

import javafx.scene.image.ImageView;

public abstract class Building extends ImageView{

    protected int health;
//    protected int X;
//    protected int Y;
//    protected ImageView image;
    protected Category category;

    public int getHealth() {
        return health;
    }


//    public ImageView getImageView() {
//        return image;
//    }
//
//    public void setImage(ImageView image) {
//        this.image = image;
//    }

    public Category getCategory() {
        return category;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
