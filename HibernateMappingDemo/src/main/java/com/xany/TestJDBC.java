package com.xany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/?user=devuser&serverTimezone=UTC";
        String usr = "devuser";
        String pwd = "Cconsalpa123";

        try {
            Connection con = DriverManager.getConnection(jdbcURL, usr, pwd);
            System.out.println(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
