package com.example.attackongoli.map;

import com.example.attackongoli.GameLauncher;
import com.example.attackongoli.map.buildings.Building;
import com.example.attackongoli.map.buildings.defenseBuilds.ArcherTower;
import com.example.attackongoli.map.buildings.defenseBuilds.Cannon;
import com.example.attackongoli.map.buildings.defenseBuilds.WizardTower;
import com.example.attackongoli.map.buildings.etc.TownHall;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class TerritoryMap implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        buildings[0] = new ArcherTower();
        buildings[1] = new WizardTower();
        buildings[2] = new Cannon();
        buildings[3] = new TownHall();
    }

    public static TerritoryMap[] maps = new TerritoryMap[4];
    private final Building[] buildings = new Building[4];
    protected final ImageView mapImage = new ImageView(GameLauncher.class.getResource("MapArena.jpg").toString());
    protected final AnchorPane anchorPane = new AnchorPane();
    protected ImageView clanImage;
    protected ImageView archerTower = new ImageView(GameLauncher.class.getResource("pngkey.com-water-tower-png-1114296.png").toString());
    protected ImageView cannon = new ImageView(GameLauncher.class.getResource("cannon.png").toString());
    protected ImageView townHall;
    protected ImageView wizardTower = new ImageView(GameLauncher.class.getResource("Wizard_Tower.png").toString());


    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public ImageView getClanImage() {
        return clanImage;
    }
}
