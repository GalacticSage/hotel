package com.mycompany.hotel.Backend.Tables;

import com.mycompany.hotel.Backend.Connection.HotelDB;

import java.sql.*;

public class Client {
    private Connection conn;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private int client_id, address_id;
    private String first_name, last_name, email, psw, phone_number;

    public Client() throws SQLException {
        this.conn = HotelDB.getInstance().getConnection();
        this.statement = conn.createStatement();
    }

    public Client(int client_id) throws SQLException {
        this.conn = HotelDB.getInstance().getConnection();
        this.statement = conn.createStatement();

        this.client_id = client_id;
        read();
    }

    public Client(String first_name, String last_name, String email, String psw, String phone_number) throws SQLException {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.psw = psw;
        this.phone_number = phone_number;

        this.conn = HotelDB.getInstance().getConnection();
        this.statement = conn.createStatement();
    }

    public void read() throws SQLException {
        preparedStatement = conn.prepareStatement("SELECT * FROM client WHERE client_id = ?");
        preparedStatement.setInt(1, client_id);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            address_id = resultSet.getInt("address_id");
            first_name = resultSet.getString("first_name");
            last_name = resultSet.getString("last_name");
            email = resultSet.getString("email");
            psw = resultSet.getString("psw");
            phone_number = resultSet.getString("phone_number");
        }
    }

    public void insert() throws SQLException {
        preparedStatement = conn.prepareStatement("INSERT INTO client (address_id, first_name, last_name, email, psw, phone_number) VALUES (?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, address_id);
        preparedStatement.setString(2, first_name);
        preparedStatement.setString(3, last_name);
        preparedStatement.setString(4, email);
        preparedStatement.setString(5, psw);
        preparedStatement.setString(6, phone_number);
        preparedStatement.executeUpdate();
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
