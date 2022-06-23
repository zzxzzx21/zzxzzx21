<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>欢迎使用银行管理用户端</title>
  <link rel="stylesheet" href="css/HomePageStyle.css">
</head>
<body>
<%!
  private String username;
%>
<%
  username = (String) session.getAttribute("usname");
%>
<div class="big_box">
  <div class="sidebar">
    <!-- sidebartop -->
    <div class="sidebar__top">
      <div class="top">
        <h2>欢迎！</h2>
      </div>
      <%--搜索栏--%>
<%--      <div class="search">--%>
    </div>
    <!--sidebar navigation -->
    <div class="sidebar__nav">
      <h5>导航菜单</h5>

      <ul class="sidebar__menu">
        <li class="sidebar__menu--item">
          <a class="sidebar__hyperlink" href="UpdateInfo.jsp" target="mainframe">个人信息</a>
        </li>

        <li class="sidebar__menu--item">
          <a class="sidebar__hyperlink" href="Property.jsp" target="mainframe">银行卡及资产信息</a>
        </li>

<%--        <li class="sidebar__menu--item">--%>
<%--          <a class="sidebar__hyperlink" href="index.jsp" target="mainframe">持有资产</a>--%>
<%--        </li>--%>

        <li class="sidebar__menu--item">
          <a class="sidebar__hyperlink" href="ShowFundItems.jsp" target="mainframe">基金</a>
        </li>
        <li class="sidebar__menu--item">
          <a class="sidebar__hyperlink" href="ShowFinanceProductItems.jsp" target="mainframe">理财产品</a>
        </li>
        <li class="sidebar__menu--item">
          <a class="sidebar__hyperlink" href="ShowInsuranceItems.jsp" target="mainframe">保险</a>
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
        <p><%=username%></p>
        <%--        <p><%=username%>></p>--%>
      </div>
      <%--    <div class="arrow">
          </div>--%>
    </div>
  </div>
  <div class="content">
    <%--点击左侧栏，加载在iframe页面中--%>
    <iframe style="background-image: url('img/money2.jpg')" id="iframe" name="mainframe" frameborder="0"></iframe>
  </div>
</div>
</body>
</html>
