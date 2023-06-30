package com.example.attackongoli;

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
    void onAttackButtonClicked(MouseEvent event) {

    }

    @FXML
    void onProfileClicked(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

}
