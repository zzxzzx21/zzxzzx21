<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/22/2022
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.bank_manager3.bean.Login" %>
<%@ page import="com.example.bank_manager3.utils.OtherStuff" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.bank_manager3.utils.DataBaseConnector" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>


<html>
<head>
    <link rel="stylesheet" href="css/index.css">
    <title>资产列表</title>
    <style>
        table {
            margin: auto;
        }

        body {
            text-align: center;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="css/Table.css">
</head>
<body>
<%

%>
<div class="get-center">
<%--<div class='get-center'><h1>个人资产及银行卡信息</h1></div>--%>
<%
    Login login = (Login) request.getSession().getAttribute("loginBean");
    if (login == null) {
        // 二次保证
        login = (Login) request.getAttribute("loginBean");
    }
    if (login != null && login.getId() > 0) {
        if (Boolean.parseBoolean(request.getParameter("buySucfcess"))) {
            // 购买成功
            request.getSession().setAttribute("buySuccess", false);     // 将购买状态改为false
            out.print("<div class='get-center'><h1>购买成功</h1></div>");
        }
        // 执行查找, 显示内容
        Connection connection = DataBaseConnector.getConnect();
        ResultSet resultSet = OtherStuff.getPropertyElements(connection,
                "SELECT * FROM finance.property WHERE pr_c_id=?", String.valueOf(login.getId()));
        if (resultSet.next()) {
            // 有数据
            out.print("<div class='get-center'><table border='1'><caption><h1>个人资产</h1></caption>" +
                    "<tr><th>产品编号</th><th>产品类型</th><th>产品数量</th>" +
                    "<th>产品状态</th><th>产品收益</th><th>产品购买时间</th><tr></div>");
            do {
                try {
                    out.print("<div class='get-center'><tr><td>" + resultSet.getInt(3) + "</td>" +
                            "<td>" + resultSet.getInt(4) + "</td><td>" + resultSet.getString(5) + "</td>" +
                            "<td>" + resultSet.getString(6) + "</td><td>" + resultSet.getDouble(7) + "</td>" +
                            "<td>" + resultSet.getString(8) + "</td><tr></div>");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } while (resultSet.next());
        } else {
            // 无数据
            out.print("<div class='get-center'><h1>暂时尚未持有任何资产</h1></div>");
        }
        resultSet = OtherStuff.getPropertyElements(connection,
                "SELECT * FROM finance.bank_card WHERE bc_c_id=?", String.valueOf(login.getId()));
        if (resultSet.next()) {
            // 有数据
            out.print("<div class='get-center'><table border='1'><caption><h1>银行卡信息</h1></caption>" +
                    "<tr><th>卡号</th><th>种类</th><th>余额</th><th>状态</th><th>透支额度</th><tr></div>");
            do {
                out.print("<div class='get-center'><tr><td>" + resultSet.getString(1) + "</td>" +
                        "<td>" + resultSet.getString(2) + "</td><td>" + resultSet.getDouble(3) + "</td>" +
                        "<td>" + resultSet.getString(4) + "</td><td>" + resultSet.getDouble(6) + "</td><tr></div>");
            } while (resultSet.next());
        } else {
            // 名下无卡
            out.print("<div class='get-center'><h1>您名下暂时没有银行卡, 请到当地银行办理</h></div>");
        }
        connection.close();
    } else {
        // 请求登陆
        out.print("<div class='picLUp'>" +
                "<div class='get-center'><h1>请先<a href='Login.jsp'>登录</a>!!!</h1></div>" +
                "</div>");
    }
%>
</div>
</body>
</html>
