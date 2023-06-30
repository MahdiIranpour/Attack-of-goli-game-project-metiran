package com.example.attackongoli.player;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ProfileViewController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Label informationLabel;

    @FXML
    private AnchorPane myMap;

    @FXML
    void backButton(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-menu.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stg.setScene(scene);
        stg.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        TerritoryMap map = TerritoryMap.maps[PlayersList.getThisPlayer().getMapIndex()];
//        this.myMap = map.getAnchorPane();
//        this.myMap.setVisible(true);

        this.informationLabel.setText(PlayersList.getThisPlayer().toString());
    }
}
