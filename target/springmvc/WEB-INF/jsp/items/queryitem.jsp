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
        function deleteItems() {
            document.itemsform.action="${pageContext.request.contextPath}/Items/deleteItems.action";
            document.itemsform.submit();
        }
        function queryItems() {
            document.itemsform.action="${pageContext.request.contextPath}/Items/queryitem.action";
            document.itemsform.submit();
        }
    </script>
</head>
<body>

<form name="itemsform" action="${pageContext.request.contextPath}/Items/queryitem.action"
      method="post" enctype="multipart/form-data">
查询条件
    <table width="100%" border="1">
        <tr>
            <td>
                商品名称<input name="itemsCustomer.name"/>
                商品类型<select name="itemtypes">
                <c:forEach var="itemtype" items="${itemtypes}">
                    <option value="${itemtype.key}">${itemtype.value}</option>
                </c:forEach>
                        </select>
            </td>
            <td>
                <input type="button" value="查询" onclick="queryItems()"/>
                <input type="button" value="批量删除" onclick="deleteItems()"/>
            </td>
            <td><a href="${pageContext.request.contextPath}/Items/editeItemsList.action">批量编辑商品</a> </td>
        </tr>
    </table>
商品列表
<table width="100%" border=1>
    <tr>
        <td>选择</td>
        <td>商品id</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>商品描述</td>
        <td>商品照片</td>
        <td>生产日期</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${itemsList}" var="item" varStatus="Status">
        <tr>
            <td><input type="checkbox" name="items_id" value="${item.id}"/></td>
            <td>${item.id }</td>
            <td>${item.name }</td>
            <td>${item.price }</td>
            <td>${item.detail }</td>
            <td><img src="/pic/${item.pic}" width="50" height="50"></td>
            <td><fmt:formatDate value="${item.creativetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td><a href="${pageContext.request.contextPath}/Items/editItems.action?id=${item.id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
