package com.example.attackongoli;

import com.example.attackongoli.player.PlayersList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {


    @FXML
    private Button enterButton;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField userNameField;

    private static String username;
    private static String password;

    @FXML
    void OnEnterButtonClicked(ActionEvent event) throws IOException {

        username = userNameField.getText();
        password = passwordField.getText();

        if (PlayersList.isLoggedIn(username, password)) {

            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-menu.fxml")));
            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stg.setScene(scene);
            stg.show();

        } else {

            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-map-menu.fxml")));
            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stg.setScene(scene);
            stg.show();
        }
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
