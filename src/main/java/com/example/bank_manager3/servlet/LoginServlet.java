package com.example.bank_manager3.servlet;

import com.example.bank_manager3.bean.Login;
import com.example.bank_manager3.utils.DataBaseConnector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 6/22/2022 - 9:49 AM
 */
public class LoginServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Login loginBean = new Login();
        HttpSession session = req.getSession(true);

        // 用户名或者密码为空, 转发到登陆界面并提示用户名/密码输入为空
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("".equals(username) || "".equals(password)) {
            loginBean.setMessage("用户名或者密码不能为空");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(req, res);
        }
        Connection connection = DataBaseConnector.getConnect();
        String getPassword = "SELECT c_password FROM finance.client WHERE c_id=" + username;
        try {
            PreparedStatement preparedPassword = connection.prepareStatement(getPassword);
            ResultSet resultSet = preparedPassword.executeQuery();
            if (resultSet.next()) {
                String realPassword = resultSet.getString(1);
                if (password.equals(realPassword)) {
                    // 此时让用户进行登陆
                    loginBean.setSuccess(true);
                    loginBean.setId(Integer.valueOf(username));
                    loginBean.setPassword(password);
                    loginBean.setMessage("登陆成功");
                    req.getSession().setAttribute("loginBean", loginBean);
                } else {
                    // 用户输入错误, 提示用户输入失败
                    loginBean.setMessage("密码输入错误, 请重新输入");
                }
            } else {
                // 没有此用户, 提示用户进行注册
                loginBean.setMessage("用户不存在, 请检查输入的id");
            }
            connection.close();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(req, res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //销毁session
        req.getSession(true).invalidate();
        resp.sendRedirect("ShowFundItems.jsp");
    }
}
