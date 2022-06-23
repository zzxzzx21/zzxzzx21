package com.example.bank_manager3.servlet;

import com.example.bank_manager3.utils.DataBaseConnector;
import com.example.bank_manager3.utils.OtherStuff;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 6/23/2022 - 8:39 AM
 */
public class UpdateInfoServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        Connection connection = DataBaseConnector.getConnect();

        if (connection == null) {
            // TODO: 数据库连接失败
        }

        try {
            // TODO 用户输入有问题 数字解析失败
            String c_name = req.getParameter("name");
            String c_phone = req.getParameter("phone_number");
            String c_id_card = req.getParameter("id_card_number");
            String c_password = req.getParameter("password");
            if (!"".equals(id)) {
                //c_id c_name c_phone c_id_card c_password
                OtherStuff.update(connection,
                        "UPDATE finance.client SET c_name=?, c_phone=?, c_id_card=?, c_password=?" +
                                " WHERE c_id=" + id, c_name, c_phone, c_id_card, c_password);
            } else {
                // TODO 用户没有输入ID
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("UpdateInfo.jsp");
        requestDispatcher.forward(req, res);
    }
}
