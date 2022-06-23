package com.example.bank_manager3.servlet;

import com.example.bank_manager3.bean.FinanceProduct;
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
 * @date 6/21/2022 - 9:20 PM
 */
public class FinanceProductServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("uTF-8");
        String keyword = req.getParameter("search");

        try {
            Connection connection = DataBaseConnector.getConnect();

            if (connection == null) {
                // TODO: 数据库连接失败处理
            }

            ResultSet resultSet = null;
            if ("".equals(keyword)) {
                resultSet = OtherStuff.showAll(connection, "SELECT * FROM finance.finances_product");
            } else {
                resultSet = OtherStuff.showSpecific(connection,
                        "SELECT * FROM finance.finances_product WHERE fp_description LIKE ?", keyword);
            }

            if (resultSet != null) {
                resultSet.next();
                List<FinanceProduct> items = getRecords(resultSet);
                req.setAttribute("allStuff", items);
            } else {
                req.setAttribute("allStuff", new ArrayList<FinanceProduct>());
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("ShowFinanceProductItems.jsp");
        requestDispatcher.forward(req, resp);
    }

    public List<FinanceProduct> getRecords(ResultSet resultSet) {
        List<FinanceProduct> list = new ArrayList<>();
        try {
            do {
                FinanceProduct element = new FinanceProduct();
                element.setFp_id(resultSet.getInt(1));
                element.setFp_name(resultSet.getString(2));
                element.setFp_description(resultSet.getString(3));
                element.setFp_amount(resultSet.getDouble(4));
                element.setBuy_link(OtherStuff.getOtherBuyLink(element.getFp_id(), OtherStuff.FINANCES_PRODUCT, element.getFp_amount(), "ShowFinanceProductItems.jsp"));
                list.add(element);
            } while (resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
