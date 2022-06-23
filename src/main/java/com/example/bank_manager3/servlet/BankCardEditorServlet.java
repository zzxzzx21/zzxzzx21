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


@WebServlet(name = "bankCardEditorServlet", value = "/bank-card-editor-servlet")
public class BankCardEditorServlet extends HttpServlet {
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

    protected void update(String bc_number, String bc_type, String bc_balance, String bc_status, String bc_c_id, String bc_overdraft) {
        //todo 其它表的更新只需要更改这一条
        String sql = "UPDATE finance.bank_card SET bc_type='" + bc_type + "',bc_balance=" + bc_balance + ",bc_status='" + bc_status + "',bc_c_id=" + bc_c_id + ",bc_overdraft=" + bc_overdraft + " WHERE bc_number=" + bc_number;
        System.out.println(sql);
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }


    protected void delete(String bc_number) {
        //删除数据
        //todo 删除前确认
        String sql = "DELETE FROM finance.bank_card WHERE bc_number = " + bc_number;
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
            String bc_number;
            String bc_type;
            String bc_balance;
            String bc_status;
            String bc_c_id;
            String bc_overdraft;


            bc_number = request.getParameter("bc_number");
            bc_type = request.getParameter("bc_type");
            bc_balance = request.getParameter("bc_balance");
            bc_status = request.getParameter("bc_status");
            bc_c_id = request.getParameter("bc_c_id");
            bc_overdraft = request.getParameter("bc_overdraft");

            //todo 调用数据库进行更新
            update(bc_number, bc_type, bc_balance, bc_status, bc_c_id, bc_overdraft);

        } else if (submit.equals("删除")) {
            String bc_number = request.getParameter("bc_number");
            System.out.println(bc_number);
            delete(bc_number);//todo 已经实现，未防止误操作，暂时注释
        } else if (submit.equals("添加")) {
            String bc_number = request.getParameter("bc_number");
            String bc_type = request.getParameter("bc_type");
            String bc_balance = request.getParameter("bc_balance");
            String bc_status = request.getParameter("bc_status");
            String bc_c_id = request.getParameter("bc_c_id");
            String bc_overdraft = request.getParameter("bc_overdraft");
            add(bc_number, bc_type, bc_balance, bc_status, bc_c_id, bc_overdraft);
        }
        response.sendRedirect("ManageBankCard.jsp");
    }

    private void add(String bc_number, String bc_type, String bc_balance, String bc_status, String bc_c_id, String bc_overdraft) {
        String sql = "INSERT INTO finance.bank_card(bc_number, bc_type, bc_balance, bc_status, bc_c_id, bc_overdraft) VALUES (" + bc_number + ",'" + bc_type + "'," + bc_balance + ",'" + bc_status + "'," + bc_c_id + "," + bc_overdraft + ")";
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
