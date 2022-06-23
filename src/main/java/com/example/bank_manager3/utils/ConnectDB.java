package com.example.bank_manager3.utils;

import java.sql.*;
public class ConnectDB {
    public static Connection getConnect(String host, String database, String port, String username, String password) {
        String driver = "org.postgresql.Driver";
        String databaseURL = "jdbc:postgresql://" + host + ":" + port + "/" + database;
        Connection conn;
        try {
            //加载驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        try {
            //创建连接
            conn = DriverManager.getConnection(databaseURL, username, password);
            System.out.println("Connection succeed!");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }
}

