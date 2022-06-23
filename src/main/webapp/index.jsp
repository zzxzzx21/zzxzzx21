<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/indexStyle.css" />
    <style>
        input::-webkit-input-placeholder { /* WebKit, Blink, Edge */
            color : ivory;
        }
        :-moz-placeholder { /* Mozilla Firefox 4 to 18 */
            color : ivory;
        }
        ::-moz-placeholder { /* Mozilla Firefox 19+ */
            color : ivory;
        }
        input:-ms-input-placeholder { /* Internet Explorer 10-11 */
            color : ivory;
        }
        input::-ms-input-placeholder { /* Microsoft Edge */
            color : ivory;
        }
    </style>
</head>
<body>
<div id="bigBox">
    <h1>登录网上银行</h1>
    <div class="inputBox">
        <div class="inputText">
                <form action="HandleLogin" method="post">
                    <div>
<%--                        <i class="fa fa-user-circle" style="color: beige"></i>--%>
                        用户名：<input type="text" placeholder="请输入用户编号" name="username"/>
                    </div>
                    <div class="inputText">
<%--                        <i class="fa fa-key" style="color: beige"></i>--%>
                        密码：<input type="password" placeholder="密码" name="password"/>
                    </div>
                    <input type="submit" class="inputButton" value="LOGIN"/>
                </form>
        </div>
        <a class="register" href="Register.jsp">没有账号？注册</a>
    </div>
</div>
</body>
</html>