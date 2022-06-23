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
    <style>
        input::-webkit-input-placeholder { /* WebKit, Blink, Edge */
            color : ivory;
        }
        :-moz-placeholder { /* Mozilla Firefox 4 to 18 */
            color : ivory;
        }
        ::-moz-placeholder { /* Mozilla Firefox 19+ */
            color : ivory;
        }
        input:-ms-input-placeholder { /* Internet Explorer 10-11 */
            color : ivory;
        }
        input::-ms-input-placeholder { /* Microsoft Edge */
            color : ivory;
        }
    </style>
    <title>注册</title></head>
    <link rel="stylesheet" href="css/Register.css">
<body>
<div id="bigBox">
    <h1>注册账户</h1>
    <div class="inputBox">
        <div class="inputText">
<%--        <div class="inputText"><p style="size: 15px"><b>账户(纯数字)</b></p></div>--%>
            <form class="" action="registerServlet" method="post">
                <div>
                    <i class="fb fb-user-id" style="color: beige;"></i>
                    <input type="number" placeholder="请输入用户名(数字)" name="user_id" required minlength="1" max="2147483647"/>
                </div>
                <div class="inputText">
                    <i class="fb fb-user-name" style="color: beige;"></i>
                    <input type="text" placeholder="请输入姓名" name="name"/>
                </div>
                <div class="inputText">
                    <i class="fb fb-user-phone" style="color: beige;"></i>
                    <input type="text" placeholder="请输入手机号码" name="phone_number" required minlength="1"/>
                </div>
                <div class="inputText">
                    <i class="fb fb-user-idcard" style="color: beige;"></i>
                    <input type="text" placeholder="请输入身份证号" name="id_card_number" required minlength="18" maxlength="18"/>
                </div>
                <div class="inputText">
                    <i class="fb fb-user-key" style="color: beige;"></i>
                    <input type="password" placeholder="请输入密码" name="password" required minlength="1" max="2147483647"/>
                </div>
                <input type="submit" class="inputButton" value="注册"/>
            </form>
            <a href="index.jsp" class="login">已有帐户？登录</a>
        </div>
        <%
            out.print("<div class='inputText'><div class=''>");
            if (registerBean.isSuccessful()) {
                response.sendRedirect("index.jsp");
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
