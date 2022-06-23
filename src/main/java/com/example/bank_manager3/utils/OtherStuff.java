package com.example.bank_manager3.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 6/21/2022 - 4:55 PM
 */
public class OtherStuff {
    public static final int FINANCES_PRODUCT = 1;
    public static final int FUND = 2;
    public static final int INSURANCE = 3;
    public static final double ZERO = 0.0000001;
    public static final String HostURL = "http://127.0.0.1:8080";

    /**
     * 保险购买 将按钮嵌套到表达中,通过点击按钮触发购买动作, 将表达法网SellHandlerServlet进行处理
     *
     * @param id    保险的主键
     * @param price 保险的价格
     * @return 可以触发购买条件的表单
     */
    public static String getInsuranceBuyLink(int id, double price, int type, String pageName) {
        return "<form action='handler' method='post'>" +
                "<input type='hidden' name='id' value='" + id + "'>" +
                "<input type='hidden' name='price' value='" + price + "'>" +
                "<input type='hidden' name='type' value='" + type + "'>" +
                "<input type='hidden' name='current_page value='" + pageName + "'>" +
                "<button type='submit' style='color: blue; height: 40px; width: 60px;'><b>购买</b></button></form>";
    }

    public static String getOtherBuyLink(int id, int type, double unitPrice, String pageName) {
        return "<form action='handler' method='post'>" +
                "<input type='hidden' name='id' value='" + id + "'>" +
                "<input type='number' name='price' required minlength='1' size='10' required max='999999999'>" +
                "<input type='hidden' name='type' value='" + type + "'>" +
                "<input type='hidden' name='unit_price' value='" + unitPrice + "'>" +
                "<input type='hidden' name='current_page' value='" + pageName + "'>" +
                "<button type='submit' style='color: blue; height: 40px; width: 60px;'><b>购买</b></button></form>";
    }

    public static ResultSet showAll(Connection connection, String search) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(search);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet showSpecific(Connection connection, String search, String... keywords) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(search);
            int i = 1;
            for (String keyword : keywords) {
                preparedStatement.setString(1,"%" + keyword + "%");
                i++;
            }
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取当前时间
    public static String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }

    // 插入操作
    public static void insert(Connection connection, String insert) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Connection connection, String update, String... keywords) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int i = 1;
            for (String keyword : keywords) {
                preparedStatement.setString(i, keyword);
                i++;
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getPropertyElements(Connection connection, String select, String... keywords) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            int i = 1;
            for (String keyword : keywords) {
                preparedStatement.setString(1, keyword);
                i++;
            }
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
