package com.example.attackongoli;

import com.example.attackongoli.player.PlayersList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML
    private TextField passwordField;

    @FXML
    private TextField userNameField;

    @FXML
    void OnEnterButtonClicked(MouseEvent event) throws IOException {

        String username = userNameField.getText();
        String password = passwordField.getText();

        if (PlayersList.isLoggedIn(username, password)) {

            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-menu.fxml")));
            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stg.setScene(scene);
            stg.show();

        } else {

            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-menu.fxml")));
            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stg.setScene(scene);
            stg.show();
        }
    }

}
