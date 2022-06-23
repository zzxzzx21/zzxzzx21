<%@ page import="com.example.bank_manager3.utils.Fund" %>
<%@ page import="com.example.bank_manager3.bean.FundBean" %>
<%@ page import="java.util.List" %>
<%--
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
    <title>Fund</title>
    <link rel="stylesheet" type="text/css" href="css/Table.css">
</head>
<body>
<%
    Fund fund = new Fund();
    List<FundBean> list;
    list = fund.getList();
%>

<table border="true" cellpadding="12">
    <tr>
        <td>
            <label>
                <input readonly="readonly" maxlength="30" type="text" value="基金编号">
                <input readonly="readonly" maxlength="30" type="text" value="基金名称">
                <input readonly="readonly" maxlength="30" type="text" value="基金类型">
                <input readonly="readonly" maxlength="30" type="text" value="基金管理者">
                <input readonly="readonly" maxlength="30" type="text" value="基金购买金额">
                <input readonly="readonly" maxlength="30" type="text" value="风险等级">
                <input readonly="readonly" maxlength="30" type="text" value="操作">
            </label>
            <input type="button" name="add" value="添加" onclick="document.getElementById('add_td').style.display=''">
        </td>
    </tr>

    <tr>
        <td style="display: none" id="add_td">
            <form action="fund-editor-servlet" method="post" onsubmit="return submit_sure()"><label>
                <input maxlength="30" type="text" name="fu_id" value="">
                <input maxlength="30" type="text" name="fu_name" value="">
                <input maxlength="30" type="text" name="fu_type" value="">
                <input maxlength="30" type="text" name="fu_manager" value="">
                <input maxlength="30" type="text" name="fu_amount" value="">
                <input maxlength="30" type="text" name="fu_risk_level" value="">
                <input type="submit" name="submit" value="添加">
            </label></form>
        </td>
    </tr>

    <% for (FundBean fundBean : list) {
    %>
    <tr>
        <td>
            <form action="fund-editor-servlet" method="get" onsubmit="return submit_sure()"><label>
                <input readonly="readonly" maxlength="30" type="text" name="fu_id"
                       value=<%=fundBean.getFu_id()%>>
                <input maxlength="30" type="text" name="fu_name"
                       value=<%=fundBean.getFu_name()%>>
                <input maxlength="30" type="text" name="fu_type" value=<%=fundBean.getFu_type()%>>
                <input maxlength="30" type="text" name="fu_manager" value=<%=fundBean.getFu_manager()%>>
                <input maxlength="30" type="text" name="fu_amount" value=<%=fundBean.getFu_amount()%>>
                <input maxlength="30" type="text" name="fu_risk_level" value=<%=fundBean.getFu_risk_level()%>>
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
