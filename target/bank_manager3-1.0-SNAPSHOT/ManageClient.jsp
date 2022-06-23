<%@ page import="com.example.bank_manager3.utils.Client" %>
<%@ page import="com.example.bank_manager3.bean.ClientBean" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Tiany
  Date: 2022/6/22
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script language="javascript">
    function submit_sure() {
        const gnl = confirm("确定要提交?");
        if (gnl === true) {
            return true;
        } else {
            return false
        }
    }
</script>
<html>
<head>
    <title>Client</title>
    <link rel="stylesheet" type="text/css" href="css/Table.css">
</head>
<body>
<%
    Client client = new Client();
    List<ClientBean> list;
    list = client.getList();
%>

<table border="true" cellpadding="5">
    <tr>
        <td>
            <label>
                <input readonly="readonly" maxlength="30" type="text" value="用户ID">
                <input readonly="readonly" maxlength="30" type="text" value="用户姓名">
                <input readonly="readonly" maxlength="30" type="text" value="用户手机">
                <input readonly="readonly" maxlength="30" type="text" value="用户身份证号">
                <input readonly="readonly" maxlength="30" type="text" value="用户密码">
                <input readonly="readonly" maxlength="30" type="text" value="操作">
            </label>
            <input type="button" name="add" value="添加"
                   onclick="document.getElementById('add_td').style.display=''">
        </td>
    </tr>
    <tr>
        <td style="display: none" id="add_td">
            <form action="client-editor-servlet" method="post" onsubmit="return submit_sure()"><label>
                <input minlength="1" max="2147483647" type="text" name="id" value="">
                <input minlength="1"  type="text" name="name" value="">
                <input minlength="11"  type="text" name="phone" value="">
                <input minlength="18" maxlength="18" type="text" name="id_card" value="">
                <input max="2147483647" type="text" name="password" value="">
                <%--todo 已实现。实现不同按钮实现不同内容的处理--%>
                <input type="submit" name="submit" value="添加">
            </label></form>
        </td>
    </tr>
    <% for (ClientBean clientBean : list) {
    %>
    <tr>
        <td>
            <form action="client-editor-servlet" method="get" onsubmit="return submit_sure()"><label>
                <input maxlength="30" readonly="readonly" type="text" name="id" value=<%=clientBean.getId()%>>
                <input maxlength="30" type="text" name="name" value=<%=clientBean.getName()%>>
                <input maxlength="30" type="text" name="phone" value=<%=clientBean.getPhone()%>>
                <input maxlength="30" type="text" name="id_card" value=<%=clientBean.getId_card()%>>
                <input maxlength="30" type="text" name="password" value=<%=clientBean.getPassword()%>>
                <%--todo 已实现。实现不同按钮实现不同内容的处理--%>
                <input type="submit" name="submit" value="修改">
                <input type="submit" name="submit" value="删除"></label></form>
        </td>

    </tr>
    <% }%>
</table>
</body>
</html>
