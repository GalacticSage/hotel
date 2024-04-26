package com.mycompany.hotel.Backend.Tables;

import com.mycompany.hotel.Backend.Connection.HotelDB;

import java.sql.*;

public class City {
    private Connection conn;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private int city_id;
    private String city_name, country_abr;

    public City() throws SQLException {
        this.conn = HotelDB.getInstance().getConnection();
        this.statement = conn.createStatement();
    }

    public City(int city_id) throws SQLException {
        this.conn = HotelDB.getInstance().getConnection();
        this.statement = conn.createStatement();

        this.city_id = city_id;
        readName();
    }

    public City(String city_name) throws SQLException {
        this.conn = HotelDB.getInstance().getConnection();
        this.statement = conn.createStatement();

        this.city_name = city_name;
        readId();
    }

    public City(int city_id, String city_name, String country_abr) throws SQLException {
        this.city_id = city_id;
        this.city_name = city_name;
        this.country_abr = country_abr;

        this.conn = HotelDB.getInstance().getConnection();
        this.statement = conn.createStatement();
    }

    public void readName() throws SQLException {
        resultSet = statement.executeQuery("SELECT city_name FROM city WHERE city_id = " + city_id);
        while (resultSet.next()) {
            city_name = resultSet.getString("city_name");
        }
        this.city_name = city_name;
    }

    public void readId() throws SQLException {
        resultSet = statement.executeQuery("SELECT city_id FROM city WHERE city_name = '" + city_name + "'");
        while (resultSet.next()) {
            city_id = resultSet.getInt("city_id");
        }
    }

    public void insert() throws SQLException {
        preparedStatement = conn.prepareStatement("INSERT INTO city (city_name, country_abr) VALUES (?, ?)");
        preparedStatement.setString(1, city_name);
        preparedStatement.setString(2, country_abr);
        preparedStatement.executeUpdate();
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCountry_abr() {
        return country_abr;
    }

    public void setCountry_abr(String country_abr) {
        this.country_abr = country_abr;
    }
}