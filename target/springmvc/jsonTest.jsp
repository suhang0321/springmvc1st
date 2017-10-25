<%--
  Created by IntelliJ IDEA.
  User: zhanghang
  Date: 2017/10/17
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json交互测试</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript">
        function requestjson () {
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/requestjson.action',
                contentType:'application/json;charset=utf-8',
                data:'{"name":"手机","price":999}',
                success:function (data) {
                    alert(data);
                }
            });
        }
        function requestkeyvalue() {
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/requestkeyvalue.action',
//                contentType:'application/json;charset=utf-8',
                data:'name=手机&price=999',
                success:function (data) {
                    alert(data);
                }
            });
        }
    </script>
</head>
<body>
<input type="button" onclick="requestjson" value="请求json串，输出json串"/>
<input type="button" onclick="requestkeyvalue" value="请求key/value串，输出json串"/>
</body>
</html>
