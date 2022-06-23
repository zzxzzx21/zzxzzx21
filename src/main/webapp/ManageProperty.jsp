<%@ page import="java.util.List" %>
<%@ page import="com.example.bank_manager3.bean.PropertyBean" %>
<%@ page import="com.example.bank_manager3.utils.Property" %>
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
    <title>Property</title>
    <link rel="stylesheet" type="text/css" href="css/Table.css">
</head>
<body>
<%
    Property property = new Property();
    List<PropertyBean> list;
    list = property.getList();
%>

<table border="true" cellpadding="5">
    <tr>
        <td>
            <label>
                <input readonly="readonly" maxlength="10" type="text" value="资产编号">
                <input readonly="readonly" maxlength="10" type="text" value="资产所有者ID">
                <input readonly="readonly" maxlength="10" type="text" value="资产产品ID">
                <input readonly="readonly" maxlength="10" type="text" value="资产产品类型">
                <input readonly="readonly" maxlength="10" type="text" value="资产产品数量">
                <input readonly="readonly" maxlength="10" type="text" value="资产产品状态">
                <input readonly="readonly" maxlength="10" type="text" value="资产产品收益">
                <input readonly="readonly" maxlength="10" type="text" value="资产产品购买时间">
                <input readonly="readonly" maxlength="10" type="text" value="操作">
            </label>
            <input type="button" name="add" value="添加"
                   onclick="document.getElementById('add_td').style.display=''">
        </td>
    </tr>
    <tr>
        <td style="display: none" id="add_td">
            <%--添加部分--%>
            <form action="property-editor-servlet" method="post" onsubmit="return submit_sure()"><label>
                <input maxlength="10" type="text" name="pr_id" value="">
                <input min="1"  max="2147483647" type="text" name="pr_c_id" value="">
                <input min="1" maxlength="10" type="text" name="pr_product_id" value="">
                <input maxlength="10" type="text" name="pr_product_type" value="">
                <input maxlength="10" type="text" name="pr_product_count" value="">
                <input maxlength="10" type="text" name="pr_product_status" value="">
                <input maxlength="10" type="text" name="pr_product_income" value="">
                <input maxlength="10" type="text" name="pr_product_time" value="">
                <input type="submit" name="submit" value="添加">
            </label></form>
        </td>
    </tr>

    <% for (PropertyBean propertyBean : list) {
    %>
    <tr>
        <td>
            <form action="property-editor-servlet" method="get" onsubmit="return submit_sure()"><label>
                <input readonly="readonly" maxlength="10" type="text" name="pr_id"
                       value=<%=propertyBean.getPr_id()%>>
                <input maxlength="10" type="text" name="pr_c_id" value=<%=propertyBean.getPr_c_id()%>>
                <input maxlength="10" type="text" name="pr_product_id" value=<%=propertyBean.getPr_product_id()%>>
                <input maxlength="10" type="text" name="pr_product_type"
                       value=<%=propertyBean.getPr_product_type()%>>
                <input maxlength="10" type="text" name="pr_product_count"
                       value=<%=propertyBean.getPr_product_count()%>>
                <input maxlength="10" type="text" name="pr_product_status"
                       value=<%=propertyBean.getPr_product_status()%>>
                <input maxlength="10" type="text" name="pr_product_income"
                       value=<%=propertyBean.getPr_product_income()%>>
                <input maxlength="10" type="text" name="pr_product_time"
                       value=<%=propertyBean.getPr_product_time()%>>
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
