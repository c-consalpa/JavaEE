<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 12/15/2020
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products Page</title>
    <link href="resources/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<p>List of available products:</p>
<table class="productsTable">
    <c:forEach items="${products}" var="item">
        <tr>
            <td>
                <a href="product.do?productId=${item.id}&action=view">${item.productName}</a>
            </td>
            <td>
                <a href="product.do?productId=${item.id}&action=add">Add to cart</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="cart.jsp"%>
</body>
</html>
