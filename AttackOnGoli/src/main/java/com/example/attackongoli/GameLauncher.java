package com.example.attackongoli;

import com.example.attackongoli.map.TerritoryMap;
import com.example.attackongoli.map.maps.TerritoryMap1;
import com.example.attackongoli.map.maps.TerritoryMap2;
import com.example.attackongoli.map.maps.TerritoryMap3;
import com.example.attackongoli.map.maps.TerritoryMap4;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameLauncher extends Application {

    @Override
    public void start(Stage stage) throws IOException {
/*
 new TerritoryMap1().setMapScene(stage);
 Media media = new Media("com/example/attackongoli/Entrance.mp3");
 MediaPlayer mediaPlayer = new MediaPlayer(media);
 mediaPlayer.play();
*/


        TerritoryMap.maps[0] = new TerritoryMap1();
        TerritoryMap.maps[1] = new TerritoryMap2();
        TerritoryMap.maps[2] = new TerritoryMap3();
        TerritoryMap.maps[3] = new TerritoryMap4();


        FXMLLoader fxmlLoader = new FXMLLoader(GameLauncher.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),960,600);
        stage.setTitle("Attack On Goli");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}