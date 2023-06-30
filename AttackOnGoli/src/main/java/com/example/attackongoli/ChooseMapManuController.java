package com.example.attackongoli;

import com.example.attackongoli.exceptions.CantInsertPlayerException;
import com.example.attackongoli.player.Player;
import com.example.attackongoli.player.PlayersDataBase;
import com.example.attackongoli.player.PlayersList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ChooseMapManuController {

    @FXML
    private Label TextLabel;

    @FXML
    private TextField mapNumberField;

    @FXML
    private Button okButton;

    @FXML
    void onOkButton(ActionEvent event) throws IOException, CantInsertPlayerException {


        int mapNumber = Integer.parseInt(mapNumberField.getText());

        if (mapNumber >= 1 && mapNumber <= 4) {


            String userName = LoginController.getUsername();
            String password = LoginController.getPassword();

            Player newPlayer = new Player(userName, password, 0, mapNumber, 0, 0);
            PlayersList.players.add(newPlayer);

            new PlayersDataBase().insertPlayer(newPlayer);

            PlayersList.setThisPlayer(newPlayer);

            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-menu.fxml")));
            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stg.setScene(scene);
            stg.show();

        } else {

            TextLabel.setText("Enter a number between 1 and 4");
        }
    }
}
