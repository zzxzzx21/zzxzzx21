package com.example.bank_manager3.utils;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 6/21/2022 - 3:47 PM
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnector {
    public static Connection getConnect() {
        String driver = "org.postgresql.Driver";


//        String databaseURL = "jdbc:postgresql://122.9.135.80:26000/finance";
        String databaseURL = "jdbc:postgresql://124.70.25.88:26000/finance";

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



//            conn = DriverManager.getConnection(databaseURL, "gaussdb", "Bigdata@123");
            conn = DriverManager.getConnection(databaseURL, "dboper", "Bigdata123");



            System.out.println("Connection succeed!");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }
}
