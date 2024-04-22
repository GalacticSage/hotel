package com.mycompany.hotel;

import java.sql.*;

public class country {
    private Connection conn;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private String country_abr;
    private String country_name;

    public country() throws SQLException {
        this.conn = DBSingleton.getInstance().getConnection();
        this.statement = conn.createStatement();
    }

    public country(String country_abr) throws SQLException {
        this.conn = DBSingleton.getInstance().getConnection();
        this.statement = conn.createStatement();

        this.country_abr = country_abr;
        readName();
    }

    public country(String country_name, boolean isName) throws SQLException {
        this.conn = DBSingleton.getInstance().getConnection();
        this.statement = conn.createStatement();

        this.country_name = country_name;
        readAbr();
    }

    public country(String country_abr, String country_name) throws SQLException {
        this.country_abr = country_abr;
        this.country_name = country_name;

        this.conn = DBSingleton.getInstance().getConnection();
        this.statement = conn.createStatement();
    }

    public void readName() throws SQLException {
        resultSet = statement.executeQuery("SELECT country_name FROM country WHERE country_abr = '" + country_abr + "'");
        while (resultSet.next()) {
            country_name = resultSet.getString("country_name");
        }
        this.country_name = country_name;
    }

    public void readAbr() throws SQLException {
        resultSet = statement.executeQuery("SELECT country_abr FROM country WHERE country_name = '" + country_name + "'");
        while (resultSet.next()) {
            country_abr = resultSet.getString("country_abr");
        }
        this.country_abr = country_abr;
    }

    public void insert() throws SQLException {
        preparedStatement = conn.prepareStatement("INSERT INTO country (country_abr, country_name) VALUES (?, ?)");
        preparedStatement.setString(1, country_abr);
        preparedStatement.setString(2, country_name);
        preparedStatement.executeUpdate();
    }

    public String getCountry_abr() {
        return country_abr;
    }

    public void setCountry_abr(String country_abr) {
        this.country_abr = country_abr;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}