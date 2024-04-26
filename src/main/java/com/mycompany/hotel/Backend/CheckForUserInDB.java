package com.mycompany.hotel.Backend;

import com.mycompany.hotel.Backend.Connection.HotelDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckForUserInDB {
    HotelDB db = HotelDB.getInstance();
    ResultSet rs;

    public CheckForUserInDB() throws SQLException, SQLException {
    }

    public String lookIfUserExists(String email) throws SQLException {
        String sql = "SELECT psw FROM client WHERE mail LIKE ?";
        PreparedStatement stmt = db.getConnection().prepareStatement(sql);
        stmt.setString(1, email);
        rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("psw");
        }
        return null;
    }
}
