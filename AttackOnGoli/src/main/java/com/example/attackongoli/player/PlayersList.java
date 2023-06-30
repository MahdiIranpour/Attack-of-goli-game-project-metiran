package com.example.attackongoli.player;

import java.util.ArrayList;
import java.util.Objects;

public class PlayersList {

    public static ArrayList<Player> players;
    private static final PlayersDataBase dataBase = new PlayersDataBase();
    private static Player thisPlayer;

    public static boolean isLoggedIn(String username, String password) {

        players = dataBase.readPlayers();

            for (Player player : players) {

                if (Objects.equals(player.getUsername(), username) && Objects.equals(player.getPassword(), password)) {

                    thisPlayer = player;
                    return true;
                }
            }

        return false;
    }

    public static Player getThisPlayer() {
        return thisPlayer;
    }

    public static void setThisPlayer(Player thisPlayer) {
        PlayersList.thisPlayer = thisPlayer;
    }
}
