package com.example.attackongoli;

import javafx.scene.Node;

public abstract class DraggableMaker {

    private static double mouseX, mouseY;

    public static void makeDraggable(Node node){

        node.setOnMousePressed(mouseEvent -> {
            mouseX = mouseEvent.getX();
            mouseY = mouseEvent.getY();
        });

        node.setOnMouseDragged(mouseEvent -> {
            node.setLayoutX(mouseEvent.getSceneX() - mouseX);
            node.setLayoutY(mouseEvent.getSceneY() - mouseY);
        });
    }

    public static void makeUnDraggable(Node node){

        node.setOnMousePressed(null);
        node.setOnMouseDragged(null);
    }
}
