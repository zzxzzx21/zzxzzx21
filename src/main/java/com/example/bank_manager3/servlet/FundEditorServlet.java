package com.example.bank_manager3.servlet;

import com.example.bank_manager3.utils.ConnectDB;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet(name = "fundEditorServlet", value = "/fund-editor-servlet")
public class FundEditorServlet extends HttpServlet {
    private Statement statement;

    public void init() {
        new ConnectDB();
        Connection connection = ConnectDB.getConnect("124.70.25.88", "finance", "26000", "dboper", "Bigdata123");
        //查询数据库,返回一个查询对象
        if (connection != null) {
            try {
                //创建语句对象
                this.statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void update(String fu_id,
                          String fu_name,
                          String fu_type,
                          String fu_manager,
                          String fu_risk_level,
                          String fu_amount) {
        //todo 其它表的更新只需要更改这一条
        String sql = "UPDATE finance.fund SET fu_name='" + fu_name + "',fu_type='" + fu_type + "',fu_manager=" + fu_manager + ",fu_risk_level='" + fu_risk_level + "',fu_amount=" + fu_amount + " WHERE fu_id=" + fu_id;
        System.out.println(sql);
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }


    protected void delete(String fu_id) {
        //删除数据
        //todo 删除前确认
        String sql = "DELETE FROM finance.fund WHERE fu_id = " + fu_id;
        System.out.println(sql);
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String submit = request.getParameter("submit");
        System.out.println("返回值：" + submit);
        if (submit.equals("修改")) {
            String fu_id;
            String fu_name;
            String fu_type;
            String fu_manager;
            String fu_risk_level;
            String fu_amount;


            fu_id = request.getParameter("fu_id");
            fu_name = request.getParameter("fu_name");
            fu_type = request.getParameter("fu_type");
            fu_manager = request.getParameter("fu_manager");
            fu_risk_level = request.getParameter("fu_risk_level");
            fu_amount = request.getParameter("fu_amount");

            //todo 调用数据库进行更新
            update(fu_id, fu_name, fu_type, fu_manager, fu_risk_level, fu_amount);

        } else if (submit.equals("删除")) {
            String fu_id = request.getParameter("fu_id");
            System.out.println(fu_id);
            delete(fu_id);//todo 已经实现，未防止误操作，暂时注释
        } else if (submit.equals("添加")) {
            String fu_id = request.getParameter("fu_id");
            String fu_name = request.getParameter("fu_name");
            String fu_type = request.getParameter("fu_type");
            String fu_manager = request.getParameter("fu_manager");
            String fu_risk_level = request.getParameter("fu_risk_level");
            String fu_amount = request.getParameter("fu_amount");
            add(fu_id, fu_name, fu_type, fu_manager, fu_risk_level, fu_amount);
        }
        response.sendRedirect("ManageFund.jsp");
    }

    private void add(String fu_id, String fu_name, String fu_type, String fu_manager, String fu_risk_level, String fu_amount) {
        String sql = "INSERT INTO finance.fund(fu_id, fu_name, fu_type, fu_manager, fu_risk_level, fu_amount) VALUES (" + fu_id + ",'" + fu_name + "','" + fu_type + "'," + fu_manager + ",'" + fu_risk_level + "'," + fu_amount + ")";
        System.out.println(sql);
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
    }

    public void destroy() {
    }

}
