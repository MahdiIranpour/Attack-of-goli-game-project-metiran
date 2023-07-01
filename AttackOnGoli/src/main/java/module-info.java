module com.example.attackongoli {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires javafx.media;


    opens com.example.attackongoli to javafx.fxml;
    exports com.example.attackongoli;
    exports com.example.attackongoli.player;
    opens com.example.attackongoli.player to javafx.fxml;
}