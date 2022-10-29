package com.example.android80;

import java.sql.Connection;
import java.sql.DriverManager;

// An highlighted block
public class MySQLConnections {
    private String driver = "";
    private String dbURL = "";
    private String user = "";
    private String password = "";
    private static MySQLConnections connection = null;
    private MySQLConnections() {
        driver = "com.mysql.jdbc.Driver";
        dbURL = "jdbc:mysql://47.112.115.77:3306/test";
        user = "root";
        password = "SzSz2003..";
        System.out.println("dbURL:" + dbURL);
    }
    public static Connection getConnection() {
        Connection conn = null;
        if (connection == null) {
            try {
                connection = new MySQLConnections();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        try {
            Class.forName(connection.driver);
            conn = DriverManager.getConnection(connection.dbURL,
                    connection.user, connection.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}