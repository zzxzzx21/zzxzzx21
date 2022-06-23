package com.example.bank_manager3.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.bank_manager3.utils.ConnectDB;



@WebServlet(name = "clientEditorServlet", value = "/client-editor-servlet")
public class ClientEditorServlet extends HttpServlet {
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

    protected void update(String id, String name, String phone, String id_card, String password) {
        //todo 其它表的更新只需要更改这一条
        String sql = "UPDATE finance.client SET c_name = '" + name + "',c_phone='" + phone + "',c_id_card='" + id_card + "',c_password='" + password + "' WHERE c_id=" + id;
        System.out.println(sql);
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    protected void delete(String c_id) {
        //删除数据
        //todo 删除前确认
        String sql = "DELETE FROM finance.client WHERE c_id = " + c_id;
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
            String id;
            String name;
            String phone;
            String id_card;
            String password;

            id = request.getParameter("id");
            name = request.getParameter("name");
            phone = request.getParameter("phone");
            id_card = request.getParameter("id_card");
            password = request.getParameter("password");

            //todo 调用数据库进行更新
            update(id, name, phone, id_card, password);
        } else if (submit.equals("删除")) {
            String id = request.getParameter("id");
            delete(id);//todo 已经实现，未防止误操作，暂时注释
        } else if (submit.equals("添加")) {
            System.out.println(request.getParameter("add"));
            //增加
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String id_card = request.getParameter("id_card");
            String password = request.getParameter("password");
            add(id, name, phone, id_card, password);
        }
        response.sendRedirect("ManageClient.jsp");
    }

    private void add(String c_id, String name, String phone, String id_card, String password) {
        String sql = "INSERT INTO finance.client(c_id,c_name,c_phone,c_id_card,c_password) VALUES(" + c_id + ",'" + name + "','" + phone + "','" + id_card + "','" + password + "')";
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
