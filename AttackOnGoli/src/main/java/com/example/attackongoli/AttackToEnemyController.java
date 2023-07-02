package com.example.attackongoli;

import com.example.attackongoli.exceptions.ThisHeroIsDead;
import com.example.attackongoli.heroes.Hero;
import com.example.attackongoli.heroes.assassins.Arno;
import com.example.attackongoli.heroes.assassins.Bear;
import com.example.attackongoli.heroes.assassins.Connor;
import com.example.attackongoli.heroes.assassins.Jacob;
import com.example.attackongoli.map.buildings.Building;
import com.example.attackongoli.map.buildings.defenseBuilds.ArcherTower;
import com.example.attackongoli.map.buildings.defenseBuilds.Cannon;
import com.example.attackongoli.map.buildings.defenseBuilds.WizardTower;
import com.example.attackongoli.map.buildings.etc.TownHall;
import com.example.attackongoli.player.Player;
import com.example.attackongoli.player.PlayersList;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;

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


    private BiMap<ImageView, Building> buildingsMap = new BiMap<>();
    private Map<ImageView, Hero> heroesMap = new HashMap<>();
    private ArrayList<Building> buildingsArrayList = new ArrayList<>();


    private Building[] buildings = new Building[4];

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

        ImageView arno = new ImageView(Objects.requireNonNull(GameLauncher.class.getResource("Arno.png")).toString());

        arno.setFitHeight(89);
        arno.setFitWidth(65);

        pain.getChildren().add(arno);
        DraggableMaker.makeDraggable(arno);

        heroesMap.put(arno, new Arno());

        HeroesOnMouseReleased(arno);
    }

//----------------------------------------------------------------------------------------

    @FXML
    void onBear(ActionEvent event) {

        ImageView bear = new ImageView(Objects.requireNonNull(GameLauncher.class.getResource("Attacking_bear.png")).toString());

        bear.setFitHeight(89);
        bear.setFitWidth(75);

        pain.getChildren().add(bear);
        DraggableMaker.makeDraggable(bear);

        heroesMap.put(bear, new Bear());

        HeroesOnMouseReleased(bear);
    }
//----------------------------------------------------------------------------------------

    @FXML
    void onConnor(ActionEvent event) {

        ImageView connor = new ImageView(Objects.requireNonNull(GameLauncher.class.getResource("Attacking_Conner.png")).toString());

        connor.setFitHeight(89);
        connor.setFitWidth(75);

        pain.getChildren().add(connor);
        DraggableMaker.makeDraggable(connor);

        heroesMap.put(connor, new Connor());

        HeroesOnMouseReleased(connor);
    }
//----------------------------------------------------------------------------------------

    @FXML
    void onJacob(ActionEvent event) {

        ImageView jacob = new ImageView(Objects.requireNonNull(GameLauncher.class.getResource("Cyndicate.png")).toString());

        jacob.setFitHeight(95);
        jacob.setFitWidth(65);

        pain.getChildren().add(jacob);
        DraggableMaker.makeDraggable(jacob);

        heroesMap.put(jacob, new Jacob());

        HeroesOnMouseReleased(jacob);
    }
//----------------------------------------------------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

        buildings[0] = new ArcherTower();
        buildings[1] = new WizardTower();
        buildings[2] = new Cannon();
        buildings[3] = new TownHall();

        for (int i = 0; i < 4; i++) {
            addNewBuilding(buildings[i]);
        }
    }
//----------------------------------------------------------------------------------------

    private void addNewBuilding(Building building) {

        ImageView thisBuildingView;
        thisBuildingView = new ImageView(building.getImageView().getImage());

        thisBuildingView.setFitWidth(100);
        thisBuildingView.setFitHeight(100);
        thisBuildingView.setLayoutX(building.getX());
        thisBuildingView.setLayoutY(building.getY());

        pain.getChildren().add(thisBuildingView);

        buildingsMap.put(thisBuildingView, building);
        buildingsArrayList.add(building);
    }

    //----------------------------------------------------------------------------------------
    private void HeroesOnMouseReleased(ImageView theHero) {

        theHero.setOnMouseReleased(e -> {

            DraggableMaker.makeUnDraggable(theHero);

            Platform.runLater(() -> {

                for (Building build : buildingsArrayList) {

                    startTransition(theHero, build);


                    try {

                        buildingRangeThread(theHero, build);
                        heroRangeThread(theHero, build);

                    } catch (RuntimeException ex) {
                        heroesMap.remove(theHero);
                        break;
                    }

                }

            });
        });
    }

    private void heroRangeThread(ImageView theHero, Building build) {

        Platform.runLater(() -> {
            try {
                setDamages(build, theHero);
            } catch (ThisHeroIsDead e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void buildingRangeThread(ImageView theHero, Building build) {

        Platform.runLater(() -> {
            try {
                setBuildingDamage(build, theHero);
            } catch (ThisHeroIsDead e) {
                throw new RuntimeException(e);
            }
        });
    }

//=============================================================================================

    private void setDamages(Building build, ImageView theHero) throws ThisHeroIsDead {

        while (build.getHealth() > 0 && heroesMap.get(theHero).getHealth() > 0) {

//            if (Math.abs(buildingsMap.getKey(build).getLayoutX() - theHero.getLayoutX()) <= 10) {

            int buildHealth = build.getHealth();
            buildHealth -= heroesMap.get(theHero).getDamage();
            build.setHealth(buildHealth);
//            }
        }

        if (build.getHealth() <= 0) {

            pain.getChildren().remove(buildingsMap.getKey(build));
            buildingsArrayList.remove(build);

        } else if (heroesMap.get(theHero).getHealth() <= 0) {

            pain.getChildren().remove(theHero);

            throw new ThisHeroIsDead();
        }
    }

//==============================================================================================

    private void setBuildingDamage(Building build, ImageView theHero) throws ThisHeroIsDead {

        if (build instanceof ArcherTower archerTower) {

//            while (build.getHealth() > 0 && heroesMap.get(theHero).getHealth() > 0) {

//                if (archerTower.getRange() >= Math.abs(buildingsMap.getKey(build).getLayoutX() - theHero.getLayoutX())
//                        && archerTower.getRange() >= Math.abs(buildingsMap.getKey(build).getLayoutX() - theHero.getLayoutX())) {

            int heroHealth = heroesMap.get(theHero).getHealth();
            heroHealth -= archerTower.getImpactPower();
            heroesMap.get(theHero).setHealth(heroHealth);
//                }
//            }
            if (heroesMap.get(theHero).getHealth() <= 0) {

                pain.getChildren().remove(theHero);
                throw new ThisHeroIsDead();

            } else if (build.getHealth() <= 0) {

                pain.getChildren().remove(buildingsMap.getKey(build));
                buildingsArrayList.remove(build);
            }

        } else if (build instanceof WizardTower wizardTower) {

//            while (heroesMap.get(theHero).getHealth() > 0) {

//                if (wizardTower.getRange() >= Math.abs(buildingsMap.getKey(build).getLayoutX() - theHero.getLayoutX())
//                        && wizardTower.getRange() >= Math.abs(buildingsMap.getKey(build).getLayoutX() - theHero.getLayoutX())) {

            int heroHealth = heroesMap.get(theHero).getHealth();
            heroHealth -= wizardTower.getImpactPower();
            heroesMap.get(theHero).setHealth(heroHealth);
//                }
//            }

        } else if (build instanceof Cannon cannon) {

//            while (heroesMap.get(theHero).getHealth() > 0) {

//                if (cannon.getRange() >= Math.abs(buildingsMap.getKey(build).getLayoutX() - theHero.getLayoutX())
//                        && cannon.getRange() >= Math.abs(buildingsMap.getKey(build).getLayoutX() - theHero.getLayoutX())) {

            int heroHealth = heroesMap.get(theHero).getHealth();
            heroHealth -= cannon.getImpactPower();
            heroesMap.get(theHero).setHealth(heroHealth);
//                }
//            }
        }
    }

    private void startTransition(ImageView theHero, Building build) {

        Platform.runLater(() -> {

            TranslateTransition transition = new TranslateTransition();

            transition.setNode(theHero);
            transition.setDuration(Duration.millis((double) 10000 / heroesMap.get(theHero).getSpeed()));

            transition.setByX(buildingsMap.getKey(build).getLayoutX() - theHero.getLayoutX());
            transition.setByY(buildingsMap.getKey(build).getLayoutY() - theHero.getLayoutY());

            ImageView t = buildingsMap.getKey(build);

            transition.play();
        });

    }
}

//==============================================================================================

class BiMap<K, V> {
    private final ObservableMap<K, V> map = FXCollections.observableHashMap();
    private final ObservableMap<V, K> inverseMap = FXCollections.observableHashMap();

    public void put(K key, V value) {
        map.put(key, value);
        inverseMap.put(value, key);
    }

    public ObservableMap<K, V> getMap() {
        return map;
    }

    public ObservableMap<V, K> getInverseMap() {
        return inverseMap;
    }

    public V getValue(K key) {
        return map.get(key);
    }

    public K getKey(V value) {
        return inverseMap.get(value);
    }
}