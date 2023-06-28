package com.example.attackongoli.player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnection {
    String URL = "jdbc:mysql://localhost/attackongoli";
    String username = "root";
    String password = "4321";

    Boolean executeSQL(String sqlCmd) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, username, password);
            Statement statement = connection.prepareStatement(sqlCmd);

            statement.execute(sqlCmd);

        } catch (Exception ex) {

            System.out.println("Error in Connecting to Data Base!\n\tPlease Check Your Connection.");
        }

        return true;
    }

    ResultSet executeQuery (String sqlCmd) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, username, password);
            Statement statement = connection.createStatement();

            return statement.executeQuery(sqlCmd);

        } catch (Exception ex) {
            return null;
        }
    }
}