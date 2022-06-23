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


@WebServlet(name = "propertyEditorServlet", value = "/property-editor-servlet")
public class PropertyEditorServlet extends HttpServlet {
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

    protected void update(String pr_id, String pr_c_id, String pr_product_id, String pr_product_type, String pr_product_count, String pr_product_status, String pr_product_income, String pr_product_time) {
        //todo 其它表的更新只需要更改这一条
        String sql = "UPDATE finance.property SET pr_c_id=" + pr_c_id + ",pr_product_id=" + pr_product_id + ",pr_product_type=" + pr_product_type + ",pr_product_count=" + pr_product_count + ",pr_product_status='" + pr_product_status + "',pr_product_income=" + pr_product_income + ",pr_product_time='" + pr_product_time + "' WHERE pr_id=" + pr_id;
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
            String pr_id;
            String pr_c_id;
            String pr_product_id;
            String pr_product_type;
            String pr_product_count;
            String pr_product_status;
            String pr_product_income;
            String pr_product_time;

            pr_id = request.getParameter("pr_id");
            pr_c_id = request.getParameter("pr_c_id");
            pr_product_id = request.getParameter("pr_product_id");
            pr_product_type = request.getParameter("pr_product_type");
            pr_product_count = request.getParameter("pr_product_count");
            pr_product_status = request.getParameter("pr_product_status");
            pr_product_income = request.getParameter("pr_product_income");
            pr_product_time = request.getParameter("pr_product_time");

            //todo 调用数据库进行更新
            update(pr_id, pr_c_id, pr_product_id, pr_product_type, pr_product_count, pr_product_status, pr_product_income, pr_product_time);
        } else if (submit.equals("删除")) {

            String pr_id = request.getParameter("pr_id");
            System.out.println(pr_id);
            delete(pr_id);//todo 已经实现，未防止误操作，暂时注释，还没测试
        } else if (submit.equals("添加")) {
            String pr_id;
            String pr_c_id;
            String pr_product_id;
            String pr_product_type;
            String pr_product_count;
            String pr_product_status;
            String pr_product_income;
            String pr_product_time;

            pr_id = request.getParameter("pr_id");
            pr_c_id = request.getParameter("pr_c_id");
            pr_product_id = request.getParameter("pr_product_id");
            pr_product_type = request.getParameter("pr_product_type");
            pr_product_count = request.getParameter("pr_product_count");
            pr_product_status = request.getParameter("pr_product_status");
            pr_product_income = request.getParameter("pr_product_income");
            pr_product_time = request.getParameter("pr_product_time");

            add(pr_id, pr_c_id, pr_product_id, pr_product_type, pr_product_count, pr_product_status, pr_product_income, pr_product_time);

        }


        response.sendRedirect("ManageProperty.jsp");
    }

    private void delete(String pr_id) {
        String sql = "DELETE FROM finance.property WHERE pr_id = " + pr_id;
        System.out.println(sql);
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    private void add(String pr_id, String pr_c_id, String pr_product_id, String pr_product_type, String pr_product_count, String pr_product_status, String pr_product_income, String pr_product_time) {
        String sql = "INSERT INTO finance.property(pr_id,pr_c_id,pr_product_id,pr_product_type,pr_product_count,pr_product_status,pr_product_income,pr_product_time) VALUES (" + pr_id + "," + pr_c_id + "," + pr_product_id + "," + pr_product_type + "," + pr_product_count + ",'" + pr_product_status + "'," + pr_product_income + ",'" + pr_product_time + "')";
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
        doPost(req, resp);
    }

    public void destroy() {
    }

}
