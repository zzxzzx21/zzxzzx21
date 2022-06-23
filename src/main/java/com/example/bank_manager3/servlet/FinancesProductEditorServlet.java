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


@WebServlet(name = "financesProductEditorServlet", value = "/finances-product-editor-servlet")
public class FinancesProductEditorServlet extends HttpServlet {
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

    protected void update(String fp_id, String fp_name, String fp_description, String fp_amount) {
        //todo 其它表的更新只需要更改这一条
        String sql = "UPDATE finance.finances_product SET fp_name = '" + fp_name + "',fp_description='" + fp_description + "',fp_amount=" + fp_amount + " WHERE fp_id=" + fp_id;
        System.out.println(sql);
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    protected void delete(String fp_id) {
        //删除数据
        //todo 删除前确认
        String sql = "DELETE FROM finance.finances_product WHERE fp_id = " + fp_id;
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
        String submit = request.getParameter("submit");
        System.out.println("返回值：" + submit);
        if (submit.equals("修改")) {
            String fp_id;
            String fp_name;
            String fp_description;
            String fp_amount;

            fp_id = request.getParameter("fp_id");
            fp_name = request.getParameter("fp_name");
            fp_description = request.getParameter("fp_description");
            fp_amount = request.getParameter("fp_amount");


            //todo 调用数据库进行更新
            update(fp_id, fp_name, fp_description, fp_amount);
        } else if (submit.equals("删除")) {
            String fp_id = request.getParameter("fp_id");
            delete(fp_id);//todo 已经实现，未防止误操作，暂时注释
        } else if (submit.equals("添加")) {
            System.out.println(request.getParameter("add"));
            //增加
            String fp_id = request.getParameter("fp_id");
            String fp_name = request.getParameter("fp_name");
            String fp_description = request.getParameter("fp_description");
            String fp_amount = request.getParameter("fp_amount");
            add(fp_id, fp_name, fp_description, fp_amount);
        }
        response.sendRedirect("ManageFinancesProduct.jsp");
    }

    private void add(String fp_id, String fp_name, String fp_description, String fp_amount) {
        String sql = "INSERT INTO finance.finances_product(fp_id,fp_name,fp_description,fp_amount) VALUES(" + fp_id + ",'" + fp_name + "','" + fp_description + "'," + fp_amount + ")";
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
