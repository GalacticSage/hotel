package com.mycompany.hotel.Backend.Tables;

import com.mycompany.hotel.Backend.Connection.HotelDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Room {
    private Connection conn;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private int room_id, floor, room_nr, max_people;
    private String description;
    private double price;

    public Room() throws Exception {
        this.conn = HotelDB.getInstance().getConnection();
        this.statement = conn.createStatement();
    }

    public Room(int room_id) throws Exception {
        this.conn = HotelDB.getInstance().getConnection();
        this.statement = conn.createStatement();

        this.room_id = room_id;
        read();
    }

    public Room(int floor, int room_nr, int max_people, String description, double price) throws Exception {
        this.floor = floor;
        this.room_nr = room_nr;
        this.max_people = max_people;
        this.description = description;
        this.price = price;

        this.conn = HotelDB.getInstance().getConnection();
        this.statement = conn.createStatement();
    }

    public void read() throws Exception {
        resultSet = statement.executeQuery("SELECT * FROM room WHERE room_id = " + room_id);
        while (resultSet.next()) {
            floor = resultSet.getInt("floor");
            room_nr = resultSet.getInt("room_nr");
            max_people = resultSet.getInt("max_people");
            description = resultSet.getString("description");
            price = resultSet.getDouble("price");
        }
    }

    public void insert() throws Exception {
        preparedStatement = conn.prepareStatement("INSERT INTO room (floor, room_nr, max_people, description, price) VALUES (?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, floor);
        preparedStatement.setInt(2, room_nr);
        preparedStatement.setInt(3, max_people);
        preparedStatement.setString(4, description);
        preparedStatement.setDouble(5, price);
        preparedStatement.executeUpdate();
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoom_nr() {
        return room_nr;
    }

    public void setRoom_nr(int room_nr) {
        this.room_nr = room_nr;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
