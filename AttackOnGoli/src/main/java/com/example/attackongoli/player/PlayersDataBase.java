package com.example.attackongoli.player;

import com.example.attackongoli.exceptions.CantInsertPlayerException;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PlayersDataBase {

    public void insertPlayer(Player player) throws CantInsertPlayerException {

        try {

            String sqlCmd = String.format
                    ("INSERT INTO `players`(`level`, `username`, `password`, `mapIndex`, `lose`, `win`) VALUES" +
                            " ('" + player.getLevel() + "','" +
                            player.getUsername() + "','" + player.getPassword() +
                            "','" + player.getMapIndex() + "','" + player.getLose() + "','" + player.getWin() + "')");

            MySQLConnection sql = new MySQLConnection();
            sql.executeSQL(sqlCmd);

        } catch (Exception ex) {
            System.out.println("Error in Sending The Message To the Data Base!");
            throw new CantInsertPlayerException();
        }
    }

    public ArrayList<Player> readPlayers() {

        String sqlCmd = ("SELECT `level`, `username`, `password`, `mapIndex`, `lose`, `win` FROM `players`");

        MySQLConnection sql = new MySQLConnection();

        try (ResultSet rs = sql.executeQuery(sqlCmd)) {

            ArrayList<Player> players = new ArrayList<>();

            while (rs.next()) {

                Player player = new Player(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("level"),
                        rs.getInt("mapIndex"),
                        rs.getInt("lose"),
                        rs.getInt("win"));

                players.add(player);
            }

            return players;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error in Selecting Data From Data Base!");
        }
        return null;
    }
}
