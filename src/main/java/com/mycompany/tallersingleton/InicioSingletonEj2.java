/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tallersingleton;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author romny
 */
public class InicioSingletonEj2 {

    public static void initDatabase() throws SQLException {
        DatabaseConnection.getInstance();
    }

    public static void main(String[] args) throws IOException, SQLException {
        // TODO code application logic here

        System.out.println("Inicio proceso singleton v2");
        initDatabase();
        System.out.println("isDbConnected: " + isDbConnected());

    }

    public static boolean isDbConnected() {
        final String CHECK_SQL_QUERY = "SELECT 1";
        boolean isConnected = false;
        try {
            Connection con = DatabaseConnection.getInstance().getConnection();
            final PreparedStatement statement = con.prepareStatement(CHECK_SQL_QUERY);
            isConnected = true;
        } catch (SQLException | NullPointerException e) {
            // handle SQL error here!
        }
        return isConnected;
    }

}
