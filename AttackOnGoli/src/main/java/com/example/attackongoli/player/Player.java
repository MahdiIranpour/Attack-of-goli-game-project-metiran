package com.example.attackongoli.player;

public class Player {

    private final String username;
    private final String password;
    private int level;
    private int mapIndex;
    private int lose = 0;
    private int win = 0;

    public Player(String username, String password, int level, int mapIndex, int lose, int win) {

        this.username = username;
        this.password = password;
        this.level = level;
        this.mapIndex = mapIndex;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getLevel() {
        return level;
    }

    public int getMapIndex() {
        return mapIndex;
    }

    public void setMapIndex(int mapIndex) {
        this.mapIndex = mapIndex;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    @Override
    public String toString() {
        return  "username : " + username + "\n" +
                "level : " + level + "\n" +
                "map : " + mapIndex + "\n"
                + "lose : " + lose + "\n"
                + "win : " + win;
    }
}
