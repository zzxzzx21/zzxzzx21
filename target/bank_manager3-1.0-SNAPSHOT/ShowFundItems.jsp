<%--
  Created by IntelliJ IDEA.
  User: Jwhan
  Date: 2021/6/27
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>


<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/Table.css">
    <link rel="stylesheet" href="css/index.css">
    <title>金融产品</title>
</head>
<body>
<div class="picLUp">
    <div class="get-center">
        <form action="fundServlet" method="post">
            <div class="input-search"><span class="input-icon"><i class="fas fa-map-marker-alt"></i></span>
                <input type="text" style="height: 40px; width: 800px" placeholder="搜索任意种类理财产品" name="search">
                <button type="submit" style="color: blue; height: 40px; width: 60px;"><b>搜索</b>
                </button>
            </div>
        </form>
    </div>
    <div class='get-center'><h1>点击即可查询</h1></div>
    <%-- 显示查询结果 --%>
    <div class='get-center'>
        <display:table name="requestScope.allStuff" class="displayTable" export="false" sort="list" pagesize="10" requestURI="">
            <display:setProperty name="paging.banner.placement" value="bottom"/>
            <display:column class="colId" property="fu_id" title="基金编号" sortable="true"/>
            <display:column class="colId" property="fu_name" title="基金名称" sortable="true"/>
            <display:column class="colId" property="fu_type" title="基金类型" sortable="true"/>
            <display:column class="colId" property="fu_manager" title="基金管理者" sortable="true"/>
            <display:column class="colId" property="fu_amount" title="基金购买金额" sortable="true"/>
            <display:column class="colId" property="fu_risk_level" title="风险等级" sortable="true"/>
            <display:column class="colId" property="buy_link" title="购买"/>
        </display:table>
    </div>
</div>
</body>
</html>
