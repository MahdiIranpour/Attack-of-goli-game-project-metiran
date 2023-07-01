package com.example.attackongoli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GameMenuController {

    @FXML
    private Button ProfileButton;

    @FXML
    private Button attackButton;

    @FXML
    private Button BackButton;

    @FXML
    private Button herosButton;

    @FXML
    void onAttackButtonClicked(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("attack-menu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onProfileClicked(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onBackButton(ActionEvent event) throws IOException {

        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onHeroButton(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("heros-list-view.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stg.setScene(scene);
        stg.show();
    }
}
