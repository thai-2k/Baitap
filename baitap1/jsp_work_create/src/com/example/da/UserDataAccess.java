package com.example.da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDataAccess {
    private PreparedStatement check;

    public PreparedStatement getCheck() throws SQLException, ClassNotFoundException {
        if (check == null){
            Connection connection = new DBconnection().getConnection();
            check = connection.prepareStatement("select * from user where username=? and password=?");
        }
        return check;
    }

}
