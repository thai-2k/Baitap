package com.example.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidateProduct {
    public static boolean insertProduct(String name, String pro_desc){

        boolean st =true;
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");
            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/t1808a1", "root","");
            PreparedStatement ps = con.prepareStatement("insert into product (name ,pro_desc) values(?,?)");
            ps.setString(1,name);
            ps.setString(2,pro_desc);
            ps.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;

    }
}
