package com.example.bank_manager3.servlet;

import com.example.bank_manager3.bean.Register;
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
 * @date 6/22/2022 - 7:10 PM
 */
public class RegisterServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Register registerBean = new Register();
        req.setAttribute("registerBean", registerBean);
        String id = req.getParameter("user_id");
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phone_number");
        String id_card_number = req.getParameter("id_card_number");
        String password = req.getParameter("password");
        System.out.println(id+name+phoneNumber+id_card_number+password);
        if ("".equals(id) || "".equals(name) || "".equals(phoneNumber) || "".equals(id_card_number) || "".equals(password)) {
            registerBean.setSuccessful(false);
            registerBean.setMessage("不能有空信息");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Register.jsp");
            requestDispatcher.forward(req, res);
            return;
        }
        // 查询数据库是否有重复信息
        Connection connection = DataBaseConnector.getConnect();
        ResultSet resultSet = OtherStuff.getPropertyElements(connection,
                "SELECT * FROM finance.client WHERE c_id=?", id);
        try {
            if (resultSet.isBeforeFirst()) {
                // 有重复的
                registerBean.setMessage("抱歉, 用户名已被占用");
                registerBean.setSuccessful(false);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("Register.jsp");
                requestDispatcher.forward(req, res);
                return;
            } else {
                // 无重复的, 插入数据库, 提示创建成功
                OtherStuff.insert(connection, "INSERT INTO finance.client VALUES ('" + id
                        + "', '" + name + "', '" + phoneNumber + "', '" + id_card_number + "', '" + password + "')");
                registerBean.setSuccessful(true);
                registerBean.setMessage("注册成功");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("Register.jsp");
                requestDispatcher.forward(req, res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
