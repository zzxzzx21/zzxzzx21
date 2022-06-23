package com.example.bank_manager3.servlet;

import com.example.bank_manager3.bean.Fund;
import com.example.bank_manager3.utils.DataBaseConnector;
import com.example.bank_manager3.utils.OtherStuff;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 6/21/2022 - 9:47 AM
 */

/**
 * 此类的主要作用是负责金融产品的后台处理操作
 */
public class FundServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    // 用来展示金融产品
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String keyword = req.getParameter("search");

        try {
            Connection connection = DataBaseConnector.getConnect();

            if (connection == null) {
                //TODO: 数据库连接失败
            }

            ResultSet resultSet = null;
            if ("".equals(keyword)) {
                resultSet = OtherStuff.showAll(connection, "SELECT * FROM finance.fund");
            } else {
                resultSet = OtherStuff.showSpecific(connection,
                        "SELECT * FROM finance.fund WHERE fu_type LIKE ?", keyword);
            }

            if (resultSet != null) {
                resultSet.next();
                // 获取结果集数据并展示结果
                List<Fund> allStuff = getRecords(resultSet);
                req.setAttribute("allStuff", allStuff);
            } else {
                req.setAttribute("allStuff", new ArrayList<Fund>());
            }
            // 查询完毕, 关闭数据库连接
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 重定向到之前查询的页面
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("ShowFundItems.jsp");
        requestDispatcher.forward(req, resp);

    }

    public List<Fund> getRecords(ResultSet resultSet) {
        List<Fund> list = new ArrayList<>();
        try {
            do {
                Fund element = new Fund();
                element.setFu_id(resultSet.getInt(1));
                element.setFu_name(resultSet.getString(2));
                element.setFu_type(resultSet.getString(3));
                element.setFu_manager(resultSet.getInt(4));
                element.setFu_risk_level(resultSet.getString(5));
                element.setFu_amount(resultSet.getDouble(6));
                element.setBuy_link(OtherStuff.getOtherBuyLink(element.getFu_id(), OtherStuff.FUND, element.getFu_amount(), "ShowFundItems.jsp"));
                list.add(element);
            } while (resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
