/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tallersingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author juanc
 */
public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection; 

    private DatabaseConnection() throws SQLException {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("database.properties");
            
            Class.forName(rb.getString("driver"));
            this.connection = DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("password"));
            if(this.connection != null){
                System.out.println("Database connection established");
            }else{
                System.out.println("Database connection established");
            }
          
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
}