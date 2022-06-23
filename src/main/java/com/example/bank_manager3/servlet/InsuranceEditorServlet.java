package com.example.bank_manager3.servlet;

import com.example.bank_manager3.utils.ConnectDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet(name = "insuranceEditorServlet", value = "/insurance-editor-servlet")
public class InsuranceEditorServlet extends HttpServlet {
    private Connection connection;
    private Statement statement;

    public void init() {
        new ConnectDB();
        this.connection = ConnectDB.getConnect("124.70.25.88", "finance", "26000", "dboper", "Bigdata123");
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

    protected void update(String in_id, String in_name, String in_item, String in_suitable_people, String in_amount) {
        //todo 其它表的更新只需要更改这一条
        String sql = "UPDATE finance.insurance SET in_name = '" + in_name + "',in_item='" + in_item + "',in_suitable_people='" + in_suitable_people + "',in_amount=" + in_amount + " WHERE in_id=" + in_id;
        System.out.println(sql);
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    protected void delete(String in_id) {
        //删除数据
        //todo 删除前确认
        String sql = "DELETE FROM finance.insurance WHERE in_id = " + in_id;
        System.out.println(sql);
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String submit=request.getParameter("submit");
        System.out.println("返回值："+submit);
        if (submit.equals("修改")) {
            String in_id;
            String in_name;
            String in_item;
            String in_suitable_people;
            String in_amount;

            in_id = request.getParameter("in_id");
            in_name = request.getParameter("in_name");
            in_item = request.getParameter("in_item");
            in_suitable_people = request.getParameter("in_suitable_people");
            in_amount = request.getParameter("in_amount");

            //todo 调用数据库进行更新
            update(in_id, in_name, in_item, in_suitable_people, in_amount);
        } else if (submit.equals("删除")) {
            String in_id = request.getParameter("in_id");
            delete(in_id);//todo 已经实现，未防止误操作，暂时注释
        } else if (submit.equals("添加")) {
            System.out.println(request.getParameter("add"));
            //增加
            String in_id = request.getParameter("in_id");
            String in_name = request.getParameter("in_name");
            String in_item = request.getParameter("in_item");
            String in_suitable_people = request.getParameter("in_suitable_people");
            String in_amount = request.getParameter("in_amount");
            add(in_id, in_name, in_item, in_suitable_people, in_amount);
        }
        response.sendRedirect("ManageInsurance.jsp");
    }

    private void add(String in_id, String in_name, String in_item, String in_suitable_people, String in_amount) {
        String sql = "INSERT INTO finance.insurance(in_id,in_name,in_item,in_suitable_people,in_amount) VALUES(" + in_id + ",'" + in_name + "','" + in_item + "','" + in_suitable_people + "'," + in_amount + ")";
        System.out.println(sql);
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
    }

    public void destroy() {

    }

}
