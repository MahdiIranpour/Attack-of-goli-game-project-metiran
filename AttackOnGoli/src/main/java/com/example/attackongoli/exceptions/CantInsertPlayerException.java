package com.example.attackongoli.exceptions;

public class CantInsertPlayerException extends Throwable {

    public CantInsertPlayerException() {
        super("Can't insert the player");
    }
}
