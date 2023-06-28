package com.example.attackongoli.player;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class PlayersList implements Initializable {

    public static ArrayList<Player> players;
    private final PlayersDataBase dataBase = new PlayersDataBase();
    private static Player thisPlayer;

    public static boolean isLoggedIn(String username, String password) {

        if (players != null) {

            for (Player player : players) {

                if (Objects.equals(player.getUsername(), username) && Objects.equals(player.getPassword(), password)) {

                    thisPlayer = player;
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        players = dataBase.readPlayers();
    }

    public Player getThisPlayer() {
        return thisPlayer;
    }
}
