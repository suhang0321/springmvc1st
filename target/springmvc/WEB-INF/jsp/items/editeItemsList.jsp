<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
    <script type="text/javascript">
        function editeItemsListSubmit() {
            document.itemsform.action="${pageContext.request.contextPath}/Items/editeItemsListSubmit.action";
            document.itemsform.submit();
        }
    </script>
</head>
<body>
<form name="itemsform" action="${pageContext.request.contextPath}/Items/editeItemsListSubmit.action"
      method="post" enctype="multipart/form-data">
    查询条件
    <table width="100%" border="1">
        <tr>
            <td>
                商品名称<input name="itemsCustomer.name"/>
            </td>
            <td>
                <input type="button" value="批量修改提交" onclick="editeItemsListSubmit()"/>
            </td>
        </tr>
    </table>
    商品列表
    <table width="100%" border=1>
        <tr>
            <td>商品id</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>商品描述</td>
            <td>商品照片</td>
            <td>生产日期</td>
        </tr>
        <c:forEach items="${itemsList}" var="item" varStatus="Status">
            <tr>
                <td><input name="itemsList[${Status.index}].id" value="${item.id }"/></td>
                <td><input name="itemsList[${Status.index}].name" value="${item.name }"/></td>
                <td><input name="itemsList[${Status.index}].price" value="${item.price }"/></td>
                <td><input name="itemsList[${Status.index}].detail" value="${item.detail }"/></td>
                <td><input name="itemsList[${Status.index}].pic" value=${item.pic}/> <img src="/pic/${item.pic}" height="50" width="50"/></td>
                <td><input name="itemsList[${Status.index}].creativetime" value="<fmt:formatDate value="${item.creativetime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
