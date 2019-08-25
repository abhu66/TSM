/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.base;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Osvaldo Erens
 */
public class ConnectionMYSQL {
    private static Connection connection;
    public static Connection getConnection(){
        try {
            //setting koneksi
              String url = "jdbc:mysql://localhost/translator_db";
              String username = "root";
              String password = "";
              connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal ! "+e.getMessage());
        }
        return connection;
    }
}
