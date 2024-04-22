package com.mycompany.hotel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckForUserInDB {
    DBSingleton db = DBSingleton.getInstance();
    ResultSet rs;

    public CheckForUserInDB() throws SQLException, SQLException {
    }

    public String lookIfUserExists(String email) throws SQLException {
        String sql = "SELECT psw FROM client WHERE email LIKE ?";
        PreparedStatement stmt = db.getConnection().prepareStatement(sql);
        stmt.setString(1, email);
        rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("psw");
        }
        return null;
    }
}
