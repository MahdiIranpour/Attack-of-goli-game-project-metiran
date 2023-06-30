package com.example.attackongoli;

import com.example.attackongoli.map.TerritoryMap;
import com.example.attackongoli.player.PlayersList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
    private ImageView myMap;

    @FXML
    void backButton(ActionEvent event) throws IOException {

        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-menu.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stg.setScene(scene);
        stg.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myMap.setImage(TerritoryMap.maps[PlayersList.getThisPlayer().getMapIndex()].getClanImage().getImage());

        this.informationLabel.setText(PlayersList.getThisPlayer().toString());
    }
}
