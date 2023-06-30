package com.example.attackongoli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HeroesListController implements Initializable {

    @FXML
    private Label arnoLabel;

    @FXML
    private Button backButton;

    @FXML
    private Label bearLabel;

    @FXML
    private Label connorLabel;

    @FXML
    private Label jacobLabel;

    @FXML
    void onBackButton(ActionEvent event) throws IOException {

        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-menu.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stg.setScene(scene);
        stg.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        arnoLabel.setText("speed : 4\nhealth : 200\ndamage : 50\nlevel require : 4\nspace : 1");
        connorLabel.setText("speed : 3.5\nhealth : 250\ndamage : 600\nlevel require : 3\nspace : 1");
        jacobLabel.setText("speed : 5\nhealth : 180\ndamage : 50\nlevel require : 2\nspace : 1");
        bearLabel.setText("speed : 2\nhealth : 400\ndamage : 25\nlevel require : 1\nspace : 3");
    }
}
