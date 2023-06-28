package com.example.attackongoli.player;

public class Player {

    private final String username;
    private final String password;
    private int level;
    private int map;
    private int lose = 0;
    private int win = 0;

    public Player(String username, String password, int level, int map){

        this.username = username;
        this.password = password;
        this.level = level;
        this.map = map;
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

    public int getMap() {
        return map;
    }

    public void setMap(int map) {
        this.map = map;
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
}
