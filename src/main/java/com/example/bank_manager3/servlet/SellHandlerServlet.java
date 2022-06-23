package com.example.bank_manager3.servlet;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 6/21/2022 - 4:59 PM
 */

import com.example.bank_manager3.bean.BankCard;
import com.example.bank_manager3.bean.Login;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用来处理各种购买操作
 */
public class SellHandlerServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double price = Double.parseDouble(req.getParameter("price"));
        int type = OtherStuff.INSURANCE;
        type = Integer.parseInt(req.getParameter("type"));
        if (type == OtherStuff.FINANCES_PRODUCT || type == OtherStuff.FUND) {
            price = price * Double.parseDouble(req.getParameter("unit_price"));
        }
        Connection connection = DataBaseConnector.getConnect();
        if (connection == null) {
            // TODO 数据库连接失败
        }

        String id = null;

        Login loginBean = (Login) req.getSession().getAttribute("loginBean");
        if (loginBean != null && loginBean.isSuccess()) {
            // 用户已经登陆成功
            id = String.valueOf(loginBean.getId());
        } else {
            resp.sendRedirect(OtherStuff.HostURL + req.getContextPath() + "/AskLogin.jsp");
            return;
        }

        int productId = Integer.parseInt(req.getParameter("id"));
        int productType = Integer.parseInt(req.getParameter("type"));

        List<BankCard> cards = getUserBankCards(connection, id);
        if (cards.size() > 0) {
            for (BankCard card : cards) {
                // 比较基金/理财产品/保险 价格 和 银行卡余额
                if (card.getBc_balance() - price > OtherStuff.ZERO) {
                    // 余额足够
                    // 删减银行卡余额
                    charge(connection, card, price, productId, productType);
                    req.getSession().setAttribute("buySuccess", true);

                    req.setAttribute("loginBean", loginBean);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("Property.jsp");
                    requestDispatcher.forward(req, resp);
//                    resp.sendRedirect(OtherStuff.HostURL + req.getContextPath() + "/Property.jsp"
//                            + "?id=" + loginBean + "");
                    return;
                }
                // TODO 购买失败
            }
//            resp.sendRedirect(OtherStuff.HostURL + req.getContextPath() + "/NoMoney.jsp");
            req.getRequestDispatcher("NoMoney.jsp").forward(req, resp);
            return;
        } else {
//            resp.sendRedirect(OtherStuff.HostURL + req.getContextPath() + "/NoCard.jsp");
            req.getRequestDispatcher("NoCard.jsp").forward(req, resp);
        }

    }


    public void charge(Connection connection, BankCard bankCard, double price, int productId, int productType) {
        String search = "UPDATE finance.bank_card SET bc_balance=" +
                (bankCard.getBc_balance() - price) +
                " WHERE bc_number=" + bankCard.getBc_number();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(search);
            preparedStatement.executeUpdate();
            updateProperty(connection, bankCard, price, productId, productType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 银行卡查询
    public List<BankCard> getUserBankCards(Connection connection, String id) {
        ResultSet resultSet = null;
        resultSet = OtherStuff.getPropertyElements(connection,
                "SELECT * FROM finance.bank_card WHERE bc_c_id = ?", id);
        return getBankCardRecords(resultSet);
    }

    // 查询银行卡信息
    public List<BankCard> getBankCardRecords(ResultSet resultSet) {
        List<BankCard> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                BankCard bankCard = new BankCard();
                bankCard.setBc_number(resultSet.getString(1));
                bankCard.setBc_balance(resultSet.getDouble(3));
                bankCard.setBc_c_id(resultSet.getInt(5));
                list.add(bankCard);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据用户购买的数量更新资产表, 这里暂时把收益设置为0
     *
     * @param connection   数据库连接
     * @param bankCard     银行卡bena
     * @param price        购买的金额
     * @param productId    产品的id
     * @param product_type 产品的种类
     */
    /**
     * 根据用户购买的数量更新资产表, 这里暂时把收益设置为0
     *
     * @param connection   数据库连接
     * @param bankCard     银行卡bena
     * @param price        购买的金额
     * @param productId    产品的id
     * @param product_type 产品的种类
     */
    public void updateProperty(Connection connection, BankCard bankCard, double price, int productId, int product_type) {
        String search = "SELECT * FROM finance.property WHERE pr_c_id=" + bankCard.getBc_c_id()
                + "AND pr_product_id=" + productId;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(search);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                int theId = getMaxId(connection) + 1;
                OtherStuff.insert(connection, "INSERT INTO finance.property VALUES " +
                        "('" + theId + "', '" +
                        bankCard.getBc_c_id() + "', '" + productId + "', '" + product_type + "', " +
                        price + ", '" + "可用', '0', '" + OtherStuff.getDate() + "')");
            } else {
                do {
                    try {
                        resultSet.next();
                        // TODO 暂时将price转为整形处理
                        if (resultSet.getInt(3) == productId) {
                            String update = "UPDATE finance.property SET pr_product_count= " +
                                    "(SELECT pr_product_count+" + price + " FROM finance.property" +
                                    " WHERE pr_c_id=" + bankCard.getBc_c_id() + " AND pr_product_id=" + productId + ")" +
                                    " WHERE pr_c_id=" + bankCard.getBc_c_id() + " AND pr_product_id=" + productId;
                            PreparedStatement preparedStatement1 = connection.prepareStatement(update);
                            preparedStatement1.executeUpdate();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } while (resultSet.next());
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 获取资产表最大id
    public int getMaxId(Connection connection) {
        ResultSet resultSet = OtherStuff.showAll(connection, "SELECT * FROM finance.property");
        int max = -1;
        try {
            if (resultSet.next()) {
                do {
                    if (resultSet.getInt(1) > max) {
                        max = resultSet.getInt(1);
                    }
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return max;
    }
}
