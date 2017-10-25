<%--
  Created by IntelliJ IDEA.
  User: zhanghang
  Date: 2017/10/18
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Login.action">
    用户名<input type="text" name="username"/><br/>
    密码<input type="password" name="password"/><br/>
    <input type="submit" value="登陆"/>
</form>
</body>
</html>
