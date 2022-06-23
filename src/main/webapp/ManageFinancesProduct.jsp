<%@ page import="com.example.bank_manager3.utils.ManagerFinancesProduct" %>
<%@ page import="com.example.bank_manager3.bean.ManagerFinancesProductBean" %>
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
    <title>FinancesProduct</title>
    <link rel="stylesheet" type="text/css" href="css/Table.css">
</head>
<body>
<%
    ManagerFinancesProduct financesProduct = new ManagerFinancesProduct();
    List<ManagerFinancesProductBean> list;
    list = financesProduct.getList();
%>

<table border="true" cellpadding="5">
    <tr>
        <td>
            <label>
                <input readonly="readonly" maxlength="30" type="text" value="产品编号">
                <input readonly="readonly" maxlength="30" type="text" value="产品名称">
                <input readonly="readonly" maxlength="30" type="text" value="产品描述">
                <input readonly="readonly" maxlength="30" type="text" value="产品金额">
                <input readonly="readonly" maxlength="30" type="text" value="操作">
            </label>
            <input type="button" name="add" value="添加"
                   onclick="document.getElementById('add_td').style.display=''">
        </td>
    </tr>
    <tr>
        <td style="display: none" id="add_td">
            <form action="finances-product-editor-servlet" method="post" onsubmit="return submit_sure()"><label>
                <input maxlength="30" type="text" name="fp_id" value="">
                <input maxlength="30" type="text" name="fp_name" value="">
                <input maxlength="300" type="text" name="fp_description" value="">
                <input maxlength="30" type="text" name="fp_amount" value="">
                <%--todo 已实现。实现不同按钮实现不同内容的处理--%>
                <input type="submit" name="submit" value="添加">
            </label></form>
        </td>
    </tr>
    <% for (ManagerFinancesProductBean financesProductBean : list) {
    %>
    <tr>
        <td>
            <form action="finances-product-editor-servlet" method="get" onsubmit="return submit_sure()"><label>
                <input maxlength="30" readonly="readonly" type="text" name="fp_id"
                       value=<%=financesProductBean.getFp_id()%>>
                <input maxlength="300" type="text" name="fp_name" value=<%=financesProductBean.getFp_name()%>>
                <input maxlength="30" type="text" name="fp_description"
                       value=<%=financesProductBean.getFp_description()%>>
                <input maxlength="30" type="text" name="fp_amount" value=<%=financesProductBean.getFp_amount()%>>
                <%--todo 已实现。实现不同按钮实现不同内容的处理--%>
                <input type="submit" name="submit" value="修改">
                <input type="submit" name="submit" value="删除"></label></form>
        </td>

    </tr>
    <% }%>
</table>
</body>
</html>
