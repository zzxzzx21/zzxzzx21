<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>欢迎使用银行管理管理端</title>
    <link rel="stylesheet" href="css/HomePageStyle.css">
</head>
<body>
<div class="big_box">
    <div class="sidebar">
        <!-- sidebartop -->
        <div class="sidebar__top">
            <div class="top">
                <h2>欢迎！</h2>
            </div>
        </div>
        <!--sidebar navigation -->
        <div class="sidebar__nav">
            <h5>导航菜单</h5>

            <ul class="sidebar__menu">
                <li class="sidebar__menu--item">
                    <a class="sidebar__hyperlink" href="ManageClient.jsp" target="mainframe">查看客户信息</a>
                </li>

                <li class="sidebar__menu--item">
                    <a class="sidebar__hyperlink" href="ManageBankCard.jsp" target="mainframe">查看银行卡信息</a>
                </li>

                <li class="sidebar__menu--item">
                    <a class="sidebar__hyperlink" href="ManageProperty.jsp" target="mainframe">查看资产信息</a>
                </li>

                <li class="sidebar__menu--item">
                    <a class="sidebar__hyperlink" href="ManageFund.jsp" target="mainframe">查看基金</a>
                </li>

                <li class="sidebar__menu--item">
                    <a class="sidebar__hyperlink" href="ManageFinancesProduct.jsp" target="mainframe">查看理财产品</a>
                </li>

                <li class="sidebar__menu--item">
                    <a class="sidebar__hyperlink" href="ManageInsurance.jsp" target="mainframe">查看保险</a>
                </li>

                <li class="sidebar__menu--item">
                    <a class="sidebar__hyperlink" href="index.jsp">退出登录</a>
                </li>
            </ul>
        </div>
        <!--下方用户-->
        <div class="sidebar__profile">
            <div class="avatar">
                <img src="" alt="">
            </div>
            <div class="admin">
                <strong>Hello</strong>
                <p>管理员</p>
                <%--        <p><%=username%>></p>--%>
            </div>
            <%--    <div class="arrow">
                </div>--%>
        </div>
    </div>
    <div class="content">
        <%--点击左侧栏，加载在iframe页面中--%>
        <iframe id="iframe" style="background-image: url('img/money2.jpg')" name="mainframe" frameborder="0"></iframe>

    </div>

</div>

</body>
</html>
