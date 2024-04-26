/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotel.Backend.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INF3A_usenj
 */
public class HotelDB {
    private static HotelDB eineDatenbankInstanz;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/hotel";
    private String username = "postgres";
    private String psw = "admin";
    
    private HotelDB(){
        try {
            this.connection = DriverManager.getConnection(url, username, psw);
        } catch (SQLException ex) {
            Logger.getLogger(HotelDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public static HotelDB getInstance() throws SQLException{
        if(eineDatenbankInstanz == null){
            eineDatenbankInstanz = new HotelDB();
        }
        else if(eineDatenbankInstanz.getConnection().isClosed()){
            eineDatenbankInstanz = new HotelDB();
        }

        return eineDatenbankInstanz;

    }
}

