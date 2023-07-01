package com.example.attackongoli;

import com.example.attackongoli.map.TerritoryMap;
import com.example.attackongoli.player.PlayersList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AttackMenuController implements Initializable {

    private int playerIndex;

    @FXML
    private Button arnoButton;

    @FXML
    private Button backButton;

    @FXML
    private Button bearButton;

    @FXML
    private Button connorButton;

    @FXML
    private Label enemyInfos;

    @FXML
    private Button jacobButton;

    @FXML
    private ImageView mapImage;

    @FXML
    private Button nextButton;

    @FXML
    void onBack(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-menu.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stg.setScene(scene);
        stg.show();
    }

    @FXML
    void onNext(MouseEvent event) {


        playerIndex++;

        if (playerIndex >= PlayersList.players.size()) {
            playerIndex = 0;
        }
        mapImage.setImage(TerritoryMap.maps[PlayersList.players.get(playerIndex).getMapIndex()].getClanImage().getImage());
        enemyInfos.setText(PlayersList.players.get(playerIndex).toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        switch (PlayersList.getThisPlayer().getLevel()) {

            case 1 -> {
                arnoButton.setVisible(false);
                jacobButton.setVisible(false);
                connorButton.setVisible(false);
            }

            case 2 -> {
                arnoButton.setVisible(false);
                connorButton.setVisible(false);
            }

            case 3 -> arnoButton.setVisible(false);
        }

        mapImage.setImage(TerritoryMap.maps[PlayersList.players.get(playerIndex).getMapIndex()].getClanImage().getImage());
        enemyInfos.setText(PlayersList.players.get(playerIndex).toString());
    }
}
