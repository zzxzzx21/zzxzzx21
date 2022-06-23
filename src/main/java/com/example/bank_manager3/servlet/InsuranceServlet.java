package com.example.bank_manager3.servlet;

import com.example.bank_manager3.bean.Insurance;
import com.example.bank_manager3.utils.DataBaseConnector;
import com.example.bank_manager3.utils.OtherStuff;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 6/21/2022 - 8:21 PM
 */
public class InsuranceServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String keyword = req.getParameter("search");

        try {
            Connection connection = DataBaseConnector.getConnect();

            if (connection == null) {
                // TODO: 数据库连接失败
            }

            ResultSet resultSet = null;
            if ("".equals(keyword)) {
                resultSet = OtherStuff.showAll(connection, "SELECT * FROM finance.insurance");
            } else {
                resultSet = OtherStuff.showSpecific(connection,
                        "SELECT * FROM finance.insurance WHERE in_item LIKE ?", keyword);
            }

            // 设置显示的查询结果
            if (resultSet != null) {
                resultSet.next();
                List<Insurance> items = getRecords(resultSet);
                req.setAttribute("allStuff", items);
            } else {
                req.setAttribute("allStuff", new ArrayList<Insurance>());
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("ShowInsuranceItems.jsp");
        requestDispatcher.forward(req, resp);
    }

    public List<Insurance> getRecords(ResultSet resultSet) {
        List<Insurance> list = new ArrayList<>();
        try {
            do {
                Insurance element = new Insurance();
                element.setIn_id(resultSet.getInt(1));
                element.setIn_name(resultSet.getString(2));
                element.setIn_item(resultSet.getString(3));
                element.setIn_suitable_people(resultSet.getString(4));
                element.setIn_amount(resultSet.getDouble(5));
                element.setBuy_link(OtherStuff.getInsuranceBuyLink(element.getIn_id(), element.getIn_amount(), OtherStuff.INSURANCE, "ShowInsuranceItems.jsp"));
                list.add(element);
            } while (resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
