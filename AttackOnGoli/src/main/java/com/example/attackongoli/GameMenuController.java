package com.example.attackongoli;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class GameMenuController {

    @FXML
    private Button ProfileButton;

    @FXML
    private Button attackButton;

    @FXML
    private Button myMapButton;

    @FXML
    void onAttackButtonClicked(MouseEvent event) {

        System.out.println("Attack");
    }

    @FXML
    void onMyMapClicked(MouseEvent event) {

        System.out.println("Map");
    }

    @FXML
    void onProfileClicked(MouseEvent event) {

        System.out.println("Profile");
    }

}
