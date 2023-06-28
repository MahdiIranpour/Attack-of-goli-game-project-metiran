package com.example.attackongoli.map;

import com.example.attackongoli.map.buildings.Building;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TerritoryMap implements Initializable {

    private final Building[] buildings = new Building[10];
    private final Image image = new Image("MapArena.png");
    private final ImageView mapImage = new ImageView(image);

    private final AnchorPane anchorPane = new AnchorPane();
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        anchorPane.getChildren().add(mapImage);
        scene = new Scene(anchorPane, 960, 600);
    }

    public void setMapScene(Stage stage){

        stage.setScene(scene);
    }
}
