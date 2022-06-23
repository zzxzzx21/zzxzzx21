<%@ page import="com.example.bank_manager3.bean.Login" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.example.bank_manager3.utils.DataBaseConnector" %>
<%@ page import="com.example.bank_manager3.utils.OtherStuff" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/23/2022
  Time: 8:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" %>
<%@ page pageEncoding="utf-8" %>
<html>
<head>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="css/Table.css">
    <title>资产列表</title>
    <style>
        table {
            margin: auto;
        }

        body {
            text-align: center;
        }
    </style>
</head>
<body>
<%

%>
<div class='get-center'><h1>个人信息</h1></div>
<%
    Login login = (Login) request.getSession().getAttribute("loginBean");
    if (login != null && login.getId() > 0) {
        // 执行查找, 显示内容
        Connection connection = DataBaseConnector.getConnect();
        ResultSet resultSet = OtherStuff.getPropertyElements(connection,
                "SELECT * FROM finance.client WHERE c_id=?", String.valueOf(login.getId()));
        if (resultSet.next()) {
            // 有数据
            out.print("<div class='get-center'><table border='1'>" +
                    "<tr><th>用户id</th><th>用户姓名</th><th>手机号码</th>" +
                    "<th>身份证号</th><th>密码</th><tr></div>");
            do {
                try {
                    // TODO: 处理id "<td><input type='text' name='id' value='" + resultSet.getInt(1) + "'></td>" +
                    out.print("<form class='form-size' action='updateInfoServlet' method='post'><tr>" +
                            "<td>" + resultSet.getInt(1) + "</td>" +
                            "<td><input type='text' name='name' value='" + resultSet.getString(2) + "' required minlength='1' maxlength='30'></td>" +
                            "<td><input type='text' name='phone_number' value='" + resultSet.getString(3) + "' required minlength='11' maxlength='11'></td>" +
                            "<td><input type='text' name='id_card_number' value='" + resultSet.getString(4) + "' required minlength='18' maxlength='18'></td>" +
                            "<td><input type='number' name='password' value='" + resultSet.getInt(5) + "' required min='100000' max='999999999'></td>" +
                            "<td><button type='submit' style='color: blue; height: 40px; width: 60px;'><b>确认修改</b></button></td><tr>" +
                            "<input type='hidden' name='id' value='" + resultSet.getInt(1) + "'></form>");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } while (resultSet.next());
        } else {
            // 无数据
            out.print("<div class='get-center'><h1>暂时尚未持有任何资产</h1></div>");
        }
        connection.close();
    } else {
        // 请求登陆
        out.print("<div class='picLUp'>" +
                "<div class='get-center'><h1>请先<a href='Login.jsp'>登录</a>!!!</h1></div>" +
                "</div>");
    }
%>
</body>
</html>

