<%@ page import="com.example.bank_manager3.utils.Insurance" %>
<%@ page import="com.example.bank_manager3.bean.ManagerInsuranceBean" %>
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
    <title>Insurance</title>
    <link rel="stylesheet" type="text/css" href="css/Table.css">
</head>
<body>
<%
    Insurance insurance = new Insurance();
    List<ManagerInsuranceBean> list;
    list = insurance.getList();
%>

<table border="true" cellpadding="5">
    <tr>
        <td>
            <label>
                <input readonly="readonly" maxlength="30" type="text" value="保险编号">
                <input readonly="readonly" maxlength="30" type="text" value="保险名称">
                <input readonly="readonly" maxlength="30" type="text" value="保险项目">
                <input readonly="readonly" maxlength="30" type="text" value="适用人群">
                <input readonly="readonly" maxlength="30" type="text" value="保险金额">
                <input readonly="readonly" maxlength="30" type="text" value="操作">
            </label>
            <input type="button" name="add" value="添加"
                   onclick="document.getElementById('add_td').style.display=''">
        </td>
    </tr>
    <tr>
        <td style="display: none" id="add_td">
            <form action="insurance-editor-servlet" method="post" onsubmit="return submit_sure()"><label>
                <input maxlength="30" type="text" name="in_id" value="">
                <input maxlength="30" type="text" name="in_name" value="">
                <input maxlength="30" type="text" name="in_item" value="">
                <input maxlength="30" type="text" name="in_suitable_people" value="">
                <input maxlength="30" type="text" name="in_amount" value="">
                <%--todo 已实现。实现不同按钮实现不同内容的处理--%>
                <input type="submit" name="submit" value="添加">
            </label></form>
        </td>
    </tr>
    <% for (ManagerInsuranceBean insuranceBean : list) {
    %>
    <tr>
        <td>
            <form action="insurance-editor-servlet" method="get" onsubmit="return submit_sure()"><label>
                <input maxlength="30" readonly="readonly" type="text" name="in_id" value=<%=insuranceBean.getIn_id()%>>
                <input maxlength="30" type="text" name="in_name" value=<%=insuranceBean.getIn_name()%>>
                <input maxlength="30" type="text" name="in_item" value=<%=insuranceBean.getIn_item()%>>
                <input maxlength="30" type="text" name="in_suitable_people"
                       value=<%=insuranceBean.getIn_suitable_people()%>>
                <input maxlength="30" type="text" name="in_amount" value=<%=insuranceBean.getIn_amount()%>>
                <%--todo 已实现。实现不同按钮实现不同内容的处理--%>
                <input type="submit" name="submit" value="修改">
                <input type="submit" name="submit" value="删除"></label></form>
        </td>

    </tr>
    <% }%>
</table>
</body>
</html>
