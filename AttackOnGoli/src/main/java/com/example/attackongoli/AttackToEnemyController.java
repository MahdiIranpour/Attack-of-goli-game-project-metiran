package com.example.attackongoli;

import com.example.attackongoli.player.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AttackToEnemyController implements Initializable {

    private static Player enemy;

    @FXML
    private Button arnoButton;

    @FXML
    private Button bearButton;

    @FXML
    private Button connorButton;

    @FXML
    private Button jacobButton;

    @FXML
    private AnchorPane pain;









    private final ImageView archerTower = new ImageView(GameLauncher.class.getResource
            ("pngkey.com-water-tower-png-1114296.png").toString());


    private final ImageView wizardTower = new ImageView(GameLauncher.class.getResource
            ("Wizard_Tower.png").toString());


    private final ImageView townHall = new ImageView(GameLauncher.class.getResource
            ("townhall.png").toString());


    private ImageView cannon = new ImageView(GameLauncher.class.getResource
            ("cannon.png").toString());















    public static Player getEnemy() {
        return enemy;
    }

    public static void setEnemy(Player enemy) {
        AttackToEnemyController.enemy = enemy;
    }

    @FXML
    void onArno(ActionEvent event) {

        ImageView arno = new ImageView(GameLauncher.class.getResource("Arno.png").toString());

        arno.setFitHeight(89);
        arno.setFitWidth(65);

        pain.getChildren().add(arno);
        DraggableMaker.makeDraggable(arno);

        arno.setOnMouseReleased(e -> {

            DraggableMaker.makeUnDraggable(arno);
        });
    }

    @FXML
    void onBear(ActionEvent event) {

        ImageView bear = new ImageView(GameLauncher.class.getResource("Attacking_bear.png").toString());

        bear.setFitHeight(89);
        bear.setFitWidth(75);

        pain.getChildren().add(bear);
        DraggableMaker.makeDraggable(bear);

        bear.setOnMouseReleased(e -> {

            DraggableMaker.makeUnDraggable(bear);
        });
    }

    @FXML
    void onConnor(ActionEvent event) {

        ImageView connor = new ImageView(GameLauncher.class.getResource("Attacking_Conner.png").toString());

        connor.setFitHeight(89);
        connor.setFitWidth(75);

        pain.getChildren().add(connor);
        DraggableMaker.makeDraggable(connor);

        connor.setOnMouseReleased(e -> {

            DraggableMaker.makeUnDraggable(connor);
        });
    }

    @FXML
    void onJacob(ActionEvent event) {

        ImageView jacob = new ImageView(GameLauncher.class.getResource("Cyndicate.png").toString());

        jacob.setFitHeight(95);
        jacob.setFitWidth(65);

        pain.getChildren().add(jacob);
        DraggableMaker.makeDraggable(jacob);

        jacob.setOnMouseReleased(e -> {

            DraggableMaker.makeUnDraggable(jacob);
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cannon.setFitHeight(89);
        cannon.setFitWidth(75);
        cannon.setX(262);
        cannon.setY(306);

        wizardTower.setFitHeight(130);
        wizardTower.setFitWidth(120);
        wizardTower.setX(528);
        wizardTower.setY(292);

        archerTower.setFitHeight(125);
        archerTower.setFitWidth(75);
        archerTower.setX(414);
        archerTower.setY(34);

        townHall.setFitHeight(103);
        townHall.setFitWidth(136);
        townHall.setX(387);
        townHall.setY(198);
    }
}
