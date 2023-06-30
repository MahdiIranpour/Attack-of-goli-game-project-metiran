package com.example.attackongoli.map.maps;

import com.example.attackongoli.GameLauncher;
import com.example.attackongoli.map.TerritoryMap;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TerritoryMap3 extends TerritoryMap {

    Scene scene;
    public TerritoryMap3(){

        this.townHall = new ImageView(GameLauncher.class.getResource("townhall.png").toString());


        mapImage.setFitHeight(630);
        mapImage.setFitWidth(906);
        mapImage.setX(-1);
        mapImage.setY(-1);

        cannon.setFitHeight(89);
        cannon.setFitWidth(75);
        cannon.setX(262);
        cannon.setY(306);

        wizardTower.setFitHeight(130);
        wizardTower.setFitWidth(120);
        wizardTower.setX(528);
        wizardTower.setY(292);

        archerTower.setFitHeight(125);
        archerTower.setFitWidth(75);
        archerTower.setX(414);
        archerTower.setY(34);

        townHall.setFitHeight(103);
        townHall.setFitWidth(136);
        townHall.setX(387);
        townHall.setY(198);

        anchorPane.getChildren().addAll(mapImage, cannon, wizardTower, archerTower, townHall);

        scene = new Scene(anchorPane, 960, 600);
    }

    public void setMapScene(Stage stage){

        stage.setScene(scene);
    }


}
