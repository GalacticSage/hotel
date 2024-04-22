package com.mycompany.hotel;

import java.sql.*;

public class address {
    private Connection conn;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private int address_id, city_id, house_number, zip_code;
    private String street;

    public address() throws SQLException {
        this.conn = DBSingleton.getInstance().getConnection();
        this.statement = conn.createStatement();
    }

    public address(int address_id) throws SQLException {
        this.conn = DBSingleton.getInstance().getConnection();
        this.statement = conn.createStatement();

        this.address_id = address_id;
        read();
    }

    public address(int city_id, int house_number, int zip_code, String street) throws SQLException {
        this.city_id = city_id;
        this.house_number = house_number;
        this.zip_code = zip_code;
        this.street = street;

        this.conn = DBSingleton.getInstance().getConnection();
        this.statement = conn.createStatement();
    }

    public void read() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM address WHERE address_id = " + address_id);
        while (resultSet.next()) {
            city_id = resultSet.getInt("city_id");
            house_number = resultSet.getInt("house_number");
            zip_code = resultSet.getInt("zip_code");
            street = resultSet.getString("street");
        }
    }

    public void insert() throws SQLException {
        preparedStatement = conn.prepareStatement("INSERT INTO address (city_id, house_number, zip_code, street) VALUES (?, ?, ?, ?)");
        preparedStatement.setInt(1, city_id);
        preparedStatement.setInt(2, house_number);
        preparedStatement.setInt(3, zip_code);
        preparedStatement.setString(4, street);
        preparedStatement.executeUpdate();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public int getHouse_number() {
        return house_number;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }
}
