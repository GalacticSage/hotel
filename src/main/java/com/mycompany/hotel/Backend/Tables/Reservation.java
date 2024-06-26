package com.mycompany.hotel.Backend.Tables;

import com.mycompany.hotel.Backend.Connection.HotelDB;

import java.sql.*;

public class Reservation {
    private Connection conn;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private int reservation_id, client_id, room_id;
    private String reservation_start, reservation_end, reservation_made;

    public Reservation() throws SQLException {
        this.conn = HotelDB.getInstance().getConnection();
        this.statement = conn.createStatement();
    }

    public Reservation(int reservation_id) throws SQLException {
        this.conn = HotelDB.getInstance().getConnection();
        this.statement = conn.createStatement();

        this.reservation_id = reservation_id;
        read();
    }

    public Reservation(int client_id, int room_id, String reservation_start, String reservation_end, String reservation_made) throws SQLException {
        this.client_id = client_id;
        this.room_id = room_id;
        this.reservation_start = reservation_start;
        this.reservation_end = reservation_end;
        this.reservation_made = reservation_made;

        this.conn = HotelDB.getInstance().getConnection();
        this.statement = conn.createStatement();
    }

    public void read() throws SQLException {
        preparedStatement = conn.prepareStatement("SELECT * FROM reservation WHERE reservation_id = ?");
        preparedStatement.setInt(1, reservation_id);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            client_id = resultSet.getInt("client_id");
            room_id = resultSet.getInt("room_id");
            reservation_start = resultSet.getString("reservation_start");
            reservation_end = resultSet.getString("reservation_end");
            reservation_made = resultSet.getString("reservation_made");
        }
    }

    public void insert() throws SQLException {
        preparedStatement = conn.prepareStatement("INSERT INTO reservation (client_id, room_id, reservation_start, reservation_end, reservation_made) VALUES (?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, client_id);
        preparedStatement.setInt(2, room_id);
        preparedStatement.setString(3, reservation_start);
        preparedStatement.setString(4, reservation_end);
        preparedStatement.setString(5, reservation_made);
        preparedStatement.executeUpdate();
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getReservation_start() {
        return reservation_start;
    }

    public void setReservation_start(String reservation_start) {
        this.reservation_start = reservation_start;
    }

    public String getReservation_end() {
        return reservation_end;
    }

    public void setReservation_end(String reservation_end) {
        this.reservation_end = reservation_end;
    }

    public String getReservation_made() {
        return reservation_made;
    }

    public void setReservation_made(String reservation_made) {
        this.reservation_made = reservation_made;
    }
}
