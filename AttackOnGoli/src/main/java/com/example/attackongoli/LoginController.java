package com.example.attackongoli;

import com.example.attackongoli.player.PlayersList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


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

//        username = userNameField.getText();
//        password = passwordField.getText();

        username = "metiran";
        password = "metiran";

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        userNameField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                passwordField.requestFocus();
            }
        });

        passwordField.setOnKeyPressed(event -> {

            username = userNameField.getText();
            password = passwordField.getText();

            if (event.getCode() == KeyCode.ENTER) {

                if (PlayersList.isLoggedIn(username, password)) {

                    Parent parent;
                    try {
                        parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-menu.fxml")));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(parent);
                    stg.setScene(scene);
                    stg.show();

                } else {

                    Parent parent;
                    try {
                        parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-map-menu.fxml")));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(parent);
                    stg.setScene(scene);
                    stg.show();
                }
            }
        });
    }
}
