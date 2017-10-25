
<%--
  Created by IntelliJ IDEA.
  User: zhanghang
  Date: 2017/10/11
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品信息</title>
</head>
<body>
<c:if test="${allErrors != null}">
    <c:forEach items="${allErrors}" var="error">
        <span style="color: red">${error.defaultMessage }</span></br>
    </c:forEach>
</c:if>
<form id="itemForm" action="${pageContext.request.contextPath}/Items/editItemsSubmit.action"
      method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${itemsCustomer.id}"/>
    修改商品信息
    <table width="100%" border="1">
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name" value="${itemsCustomer.name}"/></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="price" value="${itemsCustomer.price}"/></td>
        </tr>
        <tr>
            <td>商品描述</td>
            <td ><input type="text" name="detail" value="${itemsCustomer.detail}"/></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td>
                <c:if test="${itemsCustomer.pic!=null}">
                    <img src="/pic/${itemsCustomer.pic}" width="100" height="100"><br/>
                </c:if>
                已选择的图片：<input type="text" name="pic" value="${itemsCustomer.pic}"/><br/>
                <input type="file" name="items_pic"/>

            </td>
        </tr>
        <tr>
            <td>生产日期</td>
            <td><input type="text" name="creativetime" value="<fmt:formatDate value="${itemsCustomer.creativetime}"  pattern="yyyy-MM-dd HH:mm:ss"/>"/>

            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>

</body>
</html>
