<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/22/2022
  Time: 7:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" %>
<%@ page pageEncoding="utf-8" %>
<jsp:useBean id="registerBean" class="com.example.bank_manager3.bean.Register" scope="request"/>
<html>
<head>
    <title>注册</title></head>
    <link rel="stylesheet" href="css/index.css">
<body>
<div class="picLUp">
    <div class="login-register">
        <div class="form-line get-center"><p style="size: 15px"><b>账户(纯数字)</b></p></div>
        <form class="form-size" action="registerServlet" method="post">
            <div class="form-line">
                <div class="get-center">
                    <input type="text" size="40" id="user_id" placeholder="用户名" name="user_id">
                </div>
            </div>
            <div class="form-line">
                <div class="get-center">
                    <input type="text" size="40" id="name" placeholder="姓名" name="name">
                </div>
            </div>
            <div class="form-line">
                <div class="get-center">
                    <input type="text" size="40" id="phone_number" placeholder="手机号码" name="phone_number" required minlength="11">
                </div>
            </div>
            <div class="form-line">
                <div class="get-center">
                    <input type="text" size="40" id="id_card_number" placeholder="身份证号" name="id_card_number"
                           required minlength="18" maxlength="18">
                </div>
            </div>
            <div class="form-line">
                <div class="get-center">
                    <input type="password" size="40" id="password" placeholder="密码(纯数字)" name="password" required minlength="1">
                </div>
            </div>
            <div>
            </div>
            <div class="form-line">
                <div class="get-center">
                    <button type="submit" class="btn get-center">注册</button>
                </div>
            </div>
        </form>
        <%
            out.print("<div class=''from-line><div class='get-center'>");
            if (registerBean.isSuccessful()) {
                response.sendRedirect("Login.jsp");
            } else {
                if (registerBean.getMessage() != null) {
                    out.print("<p><b>" + registerBean.getMessage() + "</b></p>");
                }
            }
            out.print("</div></div>");
        %>
    </div>
</div>
</body>
</html>
