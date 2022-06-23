<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/21/2022
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/Table.css">

<html>
<head>
    <link rel="stylesheet" href="css/index.css">
    <title>理财产品信息</title>
</head>
<body>
<div class="picLUp">
    <div class="get-center">
        <form action="financeProductServlet" method="post">
            <div class="input-search"><span class="input-icon"><i class="fas fa-map-marker-alt"></i></span>
                <input type="text" style="height: 40px; width: 800px" placeholder="搜索任意种类理财产品" name="search">
                <button type="submit" style="color: blue; height: 40px; width: 60px; "><b>搜索</b>
                </button>
            </div>
        </form>
    </div>
    <div class='get-center'><h1>点击即可查询</h1></div>
    <%-- 显示查询结果 --%>
    <div class='get-center'>
        <display:table name="requestScope.allStuff" class="displayTable" export="false" sort="list" pagesize="10"
                       requestURI="">
            <display:setProperty name="paging.banner.placement" value="bottom"/>
            <display:column class="colId" property="fp_id" title="理财产品编号" sortable="true"/>
            <display:column class="colId" property="fp_name" title="理财产品名称" sortable="true"/>
            <display:column class="colId" property="fp_description" title="理财产品描述" sortable="true"/>
            <display:column class="colId" property="fp_amount" title="单份价格" sortable="true"/>
            <display:column class="colId" property="buy_link" title="购买"/>
        </display:table>
    </div>
</div>
</body>
</html>

