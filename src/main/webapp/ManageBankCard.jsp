<%@ page import="com.example.bank_manager3.utils.BankCard" %>
<%@ page import="com.example.bank_manager3.bean.BankCardBean" %>
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
    <title>BankCard</title>
    <link rel="stylesheet" type="text/css" href="css/Table.css">
</head>
<body>
<%
    BankCard bank_card = new BankCard();
    List<BankCardBean> list;
    list = bank_card.getList();
%>

<table border="true" cellpadding="12">
    <tr>
        <td>
            <label>
                <input readonly="readonly" maxlength="30" type="text" value="银行卡号">
                <input readonly="readonly" maxlength="30" type="text" value="银行卡类型">
                <input readonly="readonly" maxlength="30" type="text" value="银行卡余额">
                <input readonly="readonly" maxlength="30" type="text" value="银行卡状态">
                <input readonly="readonly" maxlength="30" type="text" value="持有者ID">
                <input readonly="readonly" maxlength="30" type="text" value="透支额度">
                <input readonly="readonly" maxlength="30" type="text" value="操作">
            </label>
            <input type="button" name="add" value="添加" onclick="document.getElementById('add_td').style.display=''">
        </td>
    </tr>

    <tr>
        <td style="display: none" id="add_td">
            <form action="bank-card-editor-servlet" method="post" onsubmit="return submit_sure()"><label>
                <input maxlength="30" type="text" name="bc_number" value="">
                <input maxlength="30" type="text" name="bc_type" value="">
                <input maxlength="30" type="text" name="bc_balance" value="">
                <input maxlength="30" type="text" name="bc_status" value="">
                <input min="1" max="2147483647" type="text" name="bc_c_id" value="">
                <input maxlength="30" type="text" name="c_overdraft" value="">
                <input type="submit" name="submit" value="添加">
            </label></form>
        </td>
    </tr>

    <% for (BankCardBean bankCardBean : list) {
    %>
    <tr>
        <td>
            <form action="bank-card-editor-servlet" method="get" onsubmit="return submit_sure()"><label>
                <input readonly="readonly" maxlength="30" type="text" name="bc_number"
                       value=<%=bankCardBean.getBc_number()%>>
                <input readonly="readonly" maxlength="30" type="text" name="bc_type"
                       value=<%=bankCardBean.getBc_type()%>>
                <input maxlength="30" type="text" name="bc_balance" value=<%=bankCardBean.getBc_balance()%>>
                <input maxlength="30" type="text" name="bc_status" value=<%=bankCardBean.getBc_status()%>>
                <input maxlength="30" type="text" name="bc_c_id" value=<%=bankCardBean.getBc_c_id()%>>
                <input maxlength="30" type="text" name="c_overdraft" value=<%=bankCardBean.getBc_overdraft()%>>
                <%--todo 实现不同按钮实现不同内容的处理--%>
                <input type="submit" name="submit" value="修改">
                <input type="submit" name="submit" value="删除"></label>
            </form>
        </td>

    </tr>
    <% }%>
</table>

</body>
</html>
