package com.example.attackongoli;


import com.example.attackongoli.heroes.Hero;
import com.example.attackongoli.heroes.assassins.Arno;
import com.example.attackongoli.heroes.assassins.Bear;
import com.example.attackongoli.heroes.assassins.Connor;
import com.example.attackongoli.heroes.assassins.Jacob;
import com.example.attackongoli.map.buildings.Building;
import com.example.attackongoli.map.buildings.defenseBuilds.ArcherTower;
import com.example.attackongoli.map.buildings.defenseBuilds.Cannon;
import com.example.attackongoli.map.buildings.defenseBuilds.DefenseBuilding;
import com.example.attackongoli.map.buildings.defenseBuilds.WizardTower;
import com.example.attackongoli.map.buildings.etc.TownHall;
import com.example.attackongoli.player.Player;
import com.example.attackongoli.player.PlayersList;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;


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
    protected AnchorPane pane;

    static AnchorPane pain;

    protected static ArrayList<Building> buildingsArrayList = new ArrayList<>();
    protected static ArrayList<Hero> heroesArrayList = new ArrayList<>();

    protected Building[] buildings = new Building[4];

    ImageView[] buildingsImageViews;


    private final ImageView archerTower = new ImageView(Objects.requireNonNull(GameLauncher.class.getResource
            ("pngkey.com-water-tower-png-1114296.png")).toString());


    private final ImageView wizardTower = new ImageView(Objects.requireNonNull(GameLauncher.class.getResource
            ("Wizard_Tower.png")).toString());


    private final ImageView townHall = new ImageView(Objects.requireNonNull(GameLauncher.class.getResource
            ("townhall.png")).toString());


    private ImageView cannon = new ImageView(Objects.requireNonNull(GameLauncher.class.getResource
            ("cannon.png")).toString());

    public static Player getEnemy() {
        return enemy;
    }

    public static void setEnemy(Player enemy) {
        AttackToEnemyController.enemy = enemy;
    }

//----------------------------------------------------------------------------------------

    @FXML
    void onArno(ActionEvent event) {

        Arno arno = new Arno();

        arno.setFitHeight(89);
        arno.setFitWidth(65);

        pain.getChildren().add(arno);
        DraggableMaker.makeDraggable(arno);

        heroesArrayList.add(arno);

        addNewHero(arno);
    }

//----------------------------------------------------------------------------------------

    @FXML
    void onBear(ActionEvent event) {

        Bear bear = new Bear();

        bear.setFitHeight(89);
        bear.setFitWidth(75);

        pain.getChildren().add(bear);
        DraggableMaker.makeDraggable(bear);

        heroesArrayList.add(bear);

        addNewHero(bear);
    }
//----------------------------------------------------------------------------------------

    @FXML
    void onConnor(ActionEvent event) {

        Connor connor = new Connor();

        connor.setFitHeight(89);
        connor.setFitWidth(75);

        pain.getChildren().add(connor);
        DraggableMaker.makeDraggable(connor);

        heroesArrayList.add(connor);

        addNewHero(connor);
    }
//----------------------------------------------------------------------------------------

    @FXML
    void onJacob(ActionEvent event) {

        Jacob jacob = new Jacob();

        jacob.setFitHeight(95);
        jacob.setFitWidth(65);

        pain.getChildren().add(jacob);
        DraggableMaker.makeDraggable(jacob);

        heroesArrayList.add(jacob);

        addNewHero(jacob);
    }


    //----------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------
    private void addNewBuilding(Building building) {

        building.setLayoutX(building.getX());
        building.setLayoutY(building.getY());

        pain.getChildren().add(building);

        buildingsArrayList.add(building);
    }

    Building findClosestBuilding(Hero hero) {

        double closestDistance = Double.MAX_VALUE;

        Building building = buildingsArrayList.get(0);

        for (Building value : buildingsArrayList) {


            double distance = Math.sqrt(Math.pow(value.getLayoutX() - hero.getLayoutX(), 2) +
                    Math.pow(value.getLayoutY() - hero.getLayoutY(), 2));

            if (distance < closestDistance) {

                building = value;

                closestDistance = distance;
            }
        }

        return building;
    }

    private void addNewHero(Hero hero) {


        hero.setOnMouseReleased(e -> DraggableMaker.makeUnDraggable(hero));

        for (Building building : buildingsArrayList) {

            HeroThread heroThread = new HeroThread(hero, findClosestBuilding(hero));

            Thread thread = new Thread(heroThread);
            thread.start();

            try {

                thread.join();
                System.out.println("join");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    //----------------------------------------------------------------------------------------

    static class HeroThread implements Runnable {

        private Hero hero;
        private Building building;
        private int index = 0;

        public HeroThread(Hero hero, Building building) {

            this.hero = hero;
            this.building = building;
        }
        //----------------------------------------------------------------------------------------

        @Override
        public void run() {

            startTransition();
        }
        //----------------------------------------------------------------------------------------

        private void startTransition() {

            double sourceX = hero.getBoundsInParent().getMinX();
            double sourceY = hero.getBoundsInParent().getMinY();
            double targetX = building.getBoundsInParent().getMinX();
            double targetY = building.getBoundsInParent().getMinY();

            // Calculate the translation distance
            double translateX = targetX - sourceX;
            double translateY = targetY - sourceY;

            int duration = (10000 / hero.getSpeed());

            // Create a TranslateTransition for the source ImageView
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(hero);
            transition.setDuration(Duration.millis(duration));
            transition.setToX(translateX);
            transition.setToY(translateY);
            transition.play();

            transition.setOnFinished(actionEvent -> exchangeDamage(hero, building));
//            try {
//                sleep(8000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

        }

        private void exchangeDamage(Hero hero, Building building) {

            AtomicBoolean isHeroAlive = new AtomicBoolean(true);
            AtomicBoolean isBuildingAlive = new AtomicBoolean(true);

            System.out.println(hero.getHealth());

            //hero damaging
            Thread heroDamageThread = new Thread(() -> {

                while (isHeroAlive.get() && isBuildingAlive.get()) {

                    int buildingHealth = building.getHealth();
                    buildingHealth -= hero.getDamage();
                    building.setHealth(buildingHealth);

                    if (building.getHealth() <= 0) {

                        isBuildingAlive.set(false);
//                        notify();
                        break;
                    }
                }


            });

            if (building instanceof DefenseBuilding defenseBuilding) {

                Thread buildingDamageThread = new Thread(() -> {

                    while (isHeroAlive.get() && isBuildingAlive.get()) {

                        int heroHealth = hero.getHealth();
                        heroHealth -= defenseBuilding.getImpactPower();
                        hero.setHealth(heroHealth);

                        if (hero.getHealth() <= 0) {

                            isHeroAlive.set(false);
//                            notify();
                            break;
                        }
                    }
                });

                buildingDamageThread.start();


                try {

                    heroDamageThread.join();
                    buildingDamageThread.join();


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

            if (hero.getHealth() <= 0){

                pain.getChildren().remove(hero);
                heroesArrayList.remove(hero);
            }
            if (building.getHealth() <= 0){

                pain.getChildren().remove(building);
                buildingsArrayList.remove(building);
            }
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pain = pane;

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


        addNewBuilding(new ArcherTower());
        addNewBuilding(new WizardTower());
        addNewBuilding(new Cannon());
        addNewBuilding(new TownHall());

    }
}

