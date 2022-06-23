package com.example.bank_manager3.servlet;

import com.example.bank_manager3.bean.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HandleLogin extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    Login loginBean = new Login();
    HttpSession session;
    private String username;
    private String password;
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String ManagerID = "0";
        String ManagerPasswd = "12345678";
        session = request.getSession(true);
        RequestDispatcher dispatcher = null;
        username = request.getParameter("username");
        password = request.getParameter("password");
        if(username.equals(ManagerID) && password.equals(ManagerPasswd)){
            dispatcher = request.getRequestDispatcher("Manager.jsp");
            dispatcher.forward(request,response);
            return;
        }
        String driver = "org.postgresql.Driver";
        String databaseURL = "jdbc:postgresql://" + "124.70.25.88" + ":" + "26000" + "/" + "finance";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try{
            Class.forName(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            connection = DriverManager.getConnection(databaseURL,"dboper","Bigdata123");
//            System.out.println("Connection succeed!");
            try {
                //创建语句对象
                statement = connection.createStatement();
                //查询表格
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM finance." + table + ";");
                ResultSet resultSet = statement.executeQuery("SELECT c_id,c_password,c_name FROM finance.client;");
//                int id;
                String id,pass,name;
                while (resultSet.next()) {
                    id = String.valueOf(resultSet.getInt(1));
                    pass = resultSet.getString(2);
                    if(username.equals(id) && password.equals(pass)){
                        name = resultSet.getString(3);
                        session.setAttribute("usname",name);
                        loginBean.setSuccess(true);
                        loginBean.setId(Integer.valueOf(username));
                        loginBean.setPassword(password);
                        loginBean.setMessage("登陆成功");
                        request.getSession().setAttribute("loginBean", loginBean);
//                        System.out.println(name);
                        statement.close();
                        resultSet.close();
                        dispatcher = request.getRequestDispatcher("HomePage.jsp");
                        dispatcher.forward(request,response);
                        return;
                    }
                }
                statement.close(); //查询结束，释放资源
                resultSet.close();
                response.sendRedirect("WrongPassword.jsp");
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        doPost(request,response);
    }
}
