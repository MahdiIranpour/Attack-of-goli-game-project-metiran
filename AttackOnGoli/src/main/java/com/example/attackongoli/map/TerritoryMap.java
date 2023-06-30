package com.example.attackongoli.map;

import com.example.attackongoli.GameLauncher;
import com.example.attackongoli.map.buildings.Building;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class TerritoryMap {

    public static TerritoryMap [] maps = new TerritoryMap[4];
    private final Building[] buildings = new Building[10];
    protected final ImageView mapImage = new ImageView(GameLauncher.class.getResource("MapArena.jpg").toString());
    protected final AnchorPane anchorPane = new AnchorPane();

    protected ImageView archerTower = new ImageView(GameLauncher.class.getResource("pngkey.com-water-tower-png-1114296.png").toString());
    protected ImageView cannon = new ImageView(GameLauncher.class.getResource("cannon.png").toString());
    protected ImageView townHall;
    protected ImageView wizardTower  = new ImageView(GameLauncher.class.getResource("Wizard_Tower.png").toString());


    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
}
